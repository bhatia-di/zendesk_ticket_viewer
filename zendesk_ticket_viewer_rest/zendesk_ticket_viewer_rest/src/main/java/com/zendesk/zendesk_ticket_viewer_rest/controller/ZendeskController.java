package com.zendesk.zendesk_ticket_viewer_rest.controller;

import com.zendesk.zendesk_ticket_viewer_rest.exception.ClientException;
import com.zendesk.zendesk_ticket_viewer_rest.exception.GlobalExceptionHandler;
import com.zendesk.zendesk_ticket_viewer_rest.exception.ServiceException;
import com.zendesk.zendesk_ticket_viewer_rest.service.ZendeskRestService;
import com.zendesk.zendesk_ticket_viewer_rest.view.ZendeskAPIResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ZendeskController {

    private final ZendeskRestService zendeskRestClient;


    @RequestMapping(value = {"/api/v1/tickets"}, method = RequestMethod.GET)
    @ExceptionHandler({ ClientException.class, ServiceException.class })
    public ResponseEntity listAllTickets(@RequestParam Map<String,String> requestParameters)  {
        log.info("GET Request made to API: /api/v1/tickets");
        ZendeskAPIResponse response =  zendeskRestClient.getAllTickets(requestParameters);
        return new ResponseEntity<ZendeskAPIResponse>(response, HttpStatus.OK);
    }
}
