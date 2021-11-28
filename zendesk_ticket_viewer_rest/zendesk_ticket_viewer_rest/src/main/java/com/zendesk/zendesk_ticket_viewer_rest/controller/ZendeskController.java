package com.zendesk.zendesk_ticket_viewer_rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zendesk.zendesk_ticket_viewer_rest.service.ZendeskRestClient;
import com.zendesk.zendesk_ticket_viewer_rest.view.Ticket;
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
@RestController("zendesk/")
@RequiredArgsConstructor
public class ZendeskController {

    private final ZendeskRestClient zendeskRestClient;


    @GetMapping(value = {"v1/tickets"})
    public ResponseEntity listAllTickets(@RequestParam Map<String,String> requestParameters) {
        log.info("GET Request made to API: /api/v1/tickets");
        return zendeskRestClient.getAllTickets(requestParameters);
    }
}
