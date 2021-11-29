package com.zendesk.zendesk_ticket_viewer_rest.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ClientException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;
    private LocalDateTime time;

    public ClientException(String errorMessage) {
        super(errorMessage);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.time = LocalDateTime.now();
        this.message = errorMessage;


    }


}
