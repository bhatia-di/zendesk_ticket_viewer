package com.zendesk.zendesk_ticket_viewer_rest.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ServiceException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;
    private LocalDateTime time;



    public ServiceException(String errorMessage) {
        super(errorMessage);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.time = LocalDateTime.now();
        this.message = errorMessage;

    }


}
