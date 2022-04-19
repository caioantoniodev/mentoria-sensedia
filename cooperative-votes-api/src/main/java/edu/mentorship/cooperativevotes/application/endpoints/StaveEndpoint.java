package edu.mentorship.cooperativevotes.application.endpoints;

import edu.mentorship.cooperativevotes.application.api.StaveApi;
import edu.mentorship.cooperativevotes.application.dto.InputNewStaveDto;
import edu.mentorship.cooperativevotes.application.dto.StaveDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/staves")
public class StaveEndpoint implements StaveApi {

    @Override
    @PostMapping
    public ResponseEntity<StaveDto> create(InputNewStaveDto inputNewStaveDto) {
        return StaveApi.super.create(inputNewStaveDto);
    }
}
