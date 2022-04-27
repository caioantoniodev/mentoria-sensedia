package edu.mentorship.cooperativevotes.application.usecase;

import edu.mentorship.cooperativevotes.application.dto.InputNewStaveDto;
import edu.mentorship.cooperativevotes.application.dto.StaveDto;
import edu.mentorship.cooperativevotes.core.stave.domain.Stave;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreateStave {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    public StaveDto create(InputNewStaveDto inputNewStaveDto) {
        var entity = modelMapper.map(inputNewStaveDto, Stave.class);

        mongoTemplate.save(entity);

        return modelMapper.map(entity, StaveDto.class);
    }
}
