package com.zendesk.zendesk_ticket_viewer_rest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ClientException.class, ServiceException.class})
    @ResponseBody
    protected ResponseEntity handleConflict(Throwable exception) {
      log.error("GlobalExceptionHandler::handleConflict", exception);
      if (exception instanceof ClientException) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .build();

      } else if (exception instanceof ServiceException) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                  .build();
      }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }
}
