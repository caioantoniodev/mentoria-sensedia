package edu.mentorship.cooperativevotes.application.usecase;

import edu.mentorship.cooperativevotes.application.dto.InputUpdateStaveDto;
import edu.mentorship.cooperativevotes.application.dto.StaveDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateStave {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    private final FindStave findStave;

    public StaveDto update(String id, InputUpdateStaveDto inputUpdateStaveDto) {

        //        var query = new Query(Criteria.where(ID_PROPERTY).is(id));
        //
        //        Update updateDefinition = new Update();
        //
        //        updateDefinition.set("theme", inputUpdateStaveDto.getTheme());
        //        updateDefinition.set("description", inputUpdateStaveDto.getDescription());
        //
        //        var entity = mongoTemplate.updateFirst(query, updateDefinition, Stave.class);
        //
        //        return modelMapper.map(entity, StaveDto.class);

        var staveOptional = findStave.find(id);

        if (!staveOptional.isPresent())
            return null;

        var entity = staveOptional.get();

        entity.setTheme(inputUpdateStaveDto.getTheme());
        entity.setDescription(inputUpdateStaveDto.getDescription());
        entity.updateAt();

        var staveUpdated = mongoTemplate.save(entity);

        return modelMapper.map(staveUpdated, StaveDto.class);
    }
}
