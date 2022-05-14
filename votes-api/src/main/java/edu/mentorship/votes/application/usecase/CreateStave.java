package edu.mentorship.votes.application.usecase;

import edu.mentorship.cooperativevotes.application.dto.InputNewStaveDto;
import edu.mentorship.cooperativevotes.application.dto.StaveDto;
import edu.mentorship.votes.core.stave.domain.Stave;
import edu.mentorship.votes.structure.repository.StaveRepository;
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

    @Transactional
    public StaveDto create(InputNewStaveDto inputNewStaveDto) {
        var entity = modelMapper.map(inputNewStaveDto, Stave.class);

        entity.createAt();

        staveRepository.save(entity);

        return modelMapper.map(entity, StaveDto.class);
    }
}
