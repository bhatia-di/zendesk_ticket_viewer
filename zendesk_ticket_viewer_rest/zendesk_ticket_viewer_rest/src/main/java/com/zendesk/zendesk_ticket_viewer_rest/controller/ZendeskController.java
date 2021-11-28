package com.zendesk.zendesk_ticket_viewer_rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zendesk.zendesk_ticket_viewer_rest.exception.ZendeskAPIException;
import com.zendesk.zendesk_ticket_viewer_rest.service.ZendeskRestClient;
import com.zendesk.zendesk_ticket_viewer_rest.view.Ticket;
import com.zendesk.zendesk_ticket_viewer_rest.view.ZendeskAPIResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Slf4j
@RestController
@RequiredArgsConstructor
public class ZendeskController {

    private final ZendeskRestClient zendeskRestClient;


    @RequestMapping(value = {"/api/v1/tickets"}, method = RequestMethod.GET)
    public ResponseEntity listAllTickets(@RequestParam Map<String,String> requestParameters) throws ZendeskAPIException {
        log.info("GET Request made to API: /api/v1/tickets");
        ZendeskAPIResponse response =  zendeskRestClient.getAllTickets(requestParameters);
        return new ResponseEntity<ZendeskAPIResponse>(response, HttpStatus.OK);
    }
}
