package edu.mentorship.cooperativevotes.structure.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BusinessException extends RuntimeException {

    private HttpStatus httpStatus;
    private String messageCode;
    private String[] args;

    public BusinessException(HttpStatus httpStatus, String messageCode, String[] args) {
        this.httpStatus = httpStatus;
        this.messageCode = messageCode;
        this.args = args;
    }

    public BusinessException(HttpStatus httpStatus, String messageCode) {
        this(httpStatus, messageCode, null);
    }
}
