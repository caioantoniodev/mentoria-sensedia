package edu.mentorship.cooperativevotes.application.endpoints;

import edu.mentorship.cooperativevotes.application.api.StaveApi;
import edu.mentorship.cooperativevotes.application.dto.InputNewStaveDto;
import edu.mentorship.cooperativevotes.application.dto.InputUpdateStaveDto;
import edu.mentorship.cooperativevotes.application.dto.StaveDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/staves")
public class StaveEndpoint implements StaveApi {

    @Override
    @PostMapping
    public ResponseEntity<StaveDto> create(InputNewStaveDto inputNewStaveDto) {
        return StaveApi.super.create(inputNewStaveDto);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<StaveDto> update(@PathVariable Long id, InputUpdateStaveDto inputUpdateStaveDto) {
        return StaveApi.super.update(id, inputUpdateStaveDto);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> cancel(Long id) {
        return StaveApi.super.cancel(id);
    }
}
