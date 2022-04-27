package edu.mentorship.cooperativevotes.application.rest;

import edu.mentorship.cooperativevotes.application.api.StaveApi;
import edu.mentorship.cooperativevotes.application.dto.InputNewStaveDto;
import edu.mentorship.cooperativevotes.application.dto.InputUpdateStaveDto;
import edu.mentorship.cooperativevotes.application.dto.StaveDto;
import edu.mentorship.cooperativevotes.application.usecase.CreateStave;
import edu.mentorship.cooperativevotes.application.usecase.UpdateStave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/staves")
@RequiredArgsConstructor
public class StaveEndpoint implements StaveApi {

    private final CreateStave createStave;
    private final UpdateStave updateStave;

    @Override
    @PostMapping
    public ResponseEntity<StaveDto> create(InputNewStaveDto inputNewStaveDto) {
        var payload = createStave.create(inputNewStaveDto);

        return ResponseEntity
                .status(CREATED)
                .body(payload);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<StaveDto> update(
            @PathVariable("id") Long id,
            InputUpdateStaveDto inputUpdateStaveDto) {

        var payload = updateStave.update(id, inputUpdateStaveDto);

        return ResponseEntity.status(OK).body(payload);
    }
}
