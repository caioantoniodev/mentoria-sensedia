package edu.mentorship.cooperativevotes.application.endpoints;

import edu.mentorship.cooperativevotes.AbstractContextTest;
import edu.mentorship.cooperativevotes.application.dto.InputNewStaveDto;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class StaveEndpointTest extends AbstractContextTest {

    @Test
    void shouldReturnBadRequestWhenThemeInvalid() {
        var staveDto = new InputNewStaveDto().theme("test");

        RestAssured
                .given()
                .port(port)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(staveDto, ObjectMapperType.JACKSON_2)
                .expect()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                .when()
                    .post("/api/staves");
    }
}