package edu.mentorship.cooperativevotes.application.rest;

import edu.mentorship.cooperativevotes.AbstractContextTest;
import edu.mentorship.cooperativevotes.application.dto.InputNewStaveDto;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class StaveEndpointTest extends AbstractContextTest {

    @Test
    void shouldReturnBadRequestWhenThemeInvalid() {
        var staveDto = new InputNewStaveDto().description("battle");

        RestAssured
                .given()
                .port(port)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(staveDto, ObjectMapperType.JACKSON_2)
                .expect()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("statusCode", Matchers.is(HttpStatus.BAD_REQUEST.value()))
                .body("details.findAll {it}.field", Matchers.hasItems("theme"))
                .when()
                    .post("/api/staves")
                .prettyPrint();
    }

    @Test
    void shouldReturnBadRequestWhenDescriptionInvalid() {
        var staveDto = new InputNewStaveDto().theme("battle");

        RestAssured
                .given()
                .port(port)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(staveDto, ObjectMapperType.JACKSON_2)
                .expect()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("statusCode", Matchers.is(HttpStatus.BAD_REQUEST.value()))
                .body("details.findAll {it}.field", Matchers.hasItems("description"))
                .when()
                .post("/api/staves")
                .prettyPrint();
    }

    @Test
    void shouldReturnBadRequestWhenThemeLeesThanFive() {
        var staveDto = new InputNewStaveDto()
                .theme("also")
                .description("creature");

        RestAssured
                .given()
                .port(port)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(staveDto, ObjectMapperType.JACKSON_2)
                .expect()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("statusCode", Matchers.is(HttpStatus.BAD_REQUEST.value()))
                .body("details.findAll {it}.descriptionError", Matchers.hasItems("tamanho deve ser entre 5 e 100"))
                .when()
                .post("/api/staves")
                .prettyPrint();
    }

    @Test
    void shouldReturnBadRequestWhenDescriptionLeesThanFive() {
        var staveDto = new InputNewStaveDto()
                .theme("noise")
                .description("dust");

        RestAssured
                .given()
                .port(port)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(staveDto, ObjectMapperType.JACKSON_2)
                .expect()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("statusCode", Matchers.is(HttpStatus.BAD_REQUEST.value()))
                .body("details.findAll {it}.descriptionError", Matchers.hasItems("tamanho deve ser entre 5 e 255"))
                .when()
                .post("/api/staves")
                .prettyPrint();
    }
}