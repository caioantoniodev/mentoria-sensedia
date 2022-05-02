package edu.mentorship.cooperativevotes.application.usecase;

import edu.mentorship.cooperativevotes.application.dto.InputUpdateStaveDto;
import edu.mentorship.cooperativevotes.application.dto.StaveDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import static java.lang.Boolean.FALSE;

@Component
@RequiredArgsConstructor
public class UpdateStave {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    private final FindStave findStave;

    public StaveDto update(String id, InputUpdateStaveDto inputUpdateStaveDto) {

        var staveOptional = findStave.find(id);

        if (staveOptional.isEmpty())
            return null;

        var entity = staveOptional.get();

        if (FALSE.equals(entity.getTheme().equals(inputUpdateStaveDto.getTheme()))) {
            var hasStave = findStave.findByThemeAndStateIsSessionVotesDone(
                    inputUpdateStaveDto.getTheme());

            if (hasStave.isPresent())
                throw new RuntimeException();
        }

        entity.setTheme(inputUpdateStaveDto.getTheme());
        entity.setDescription(inputUpdateStaveDto.getDescription());
        entity.updateAt();

        var staveUpdated = mongoTemplate.save(entity);

        return modelMapper.map(staveUpdated, StaveDto.class);
    }
}
