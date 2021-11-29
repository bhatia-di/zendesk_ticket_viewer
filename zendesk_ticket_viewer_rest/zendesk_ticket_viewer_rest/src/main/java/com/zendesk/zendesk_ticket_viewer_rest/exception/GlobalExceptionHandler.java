package com.zendesk.zendesk_ticket_viewer_rest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ClientException.class, ServiceException.class})
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)

    protected ResponseEntity handleClientAndServiceException(Throwable exception) {
      log.error("GlobalExceptionHandler::handleConflict", exception);
      if (exception instanceof ClientException) {
          return new ResponseEntity<>(new ClientException(exception.getMessage()), HttpStatus.BAD_REQUEST);


      } else if (exception instanceof ServiceException) {
          return new ResponseEntity<>(new ServiceException(exception.getMessage()), HttpStatus.BAD_REQUEST);
      }

        return new ResponseEntity<>(new ServiceException(exception.getMessage()), HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(value = {Throwable.class})
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    protected ResponseEntity handleException(Throwable exception) {

        return new ResponseEntity<>(new ServiceException(exception.getMessage()), HttpStatus.BAD_REQUEST);

    }
}
