package edu.mentorship.cooperativevotes.application.usecase;

import edu.mentorship.cooperativevotes.application.dto.InputNewStaveDto;
import edu.mentorship.cooperativevotes.application.dto.StaveDto;
import edu.mentorship.cooperativevotes.structure.repository.StaveRepository;
import edu.mentorship.cooperativevotes.core.stave.domain.Stave;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateStave {

    private final ModelMapper modelMapper;

    private final StaveRepository staveRepository;

    @Transactional(value = "MONGO_TRANSACTION_MANAGER")
    public StaveDto create(InputNewStaveDto inputNewStaveDto) {
        var entity = modelMapper.map(inputNewStaveDto, Stave.class);

        entity.setId(UUID.randomUUID().toString());
        entity.createAt();

        staveRepository.save(entity);

        return modelMapper.map(entity, StaveDto.class);
    }
}
