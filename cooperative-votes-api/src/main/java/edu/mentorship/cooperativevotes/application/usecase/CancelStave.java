package edu.mentorship.cooperativevotes.application.usecase;

import edu.mentorship.cooperativevotes.structure.repository.StaveRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CancelStave {

    private final ModelMapper modelMapper;

    private final StaveRepository staveRepository;

    public void cancelStave(String id) {
        // TODO
    }
}
