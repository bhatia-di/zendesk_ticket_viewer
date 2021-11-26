package com.zendesk.zendesk_ticket_viewer_rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zendesk.zendesk_ticket_viewer_rest.service.ZendeskRestClient;
import com.zendesk.zendesk_ticket_viewer_rest.view.Ticket;
import com.zendesk.zendesk_ticket_viewer_rest.view.TicketList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ZendeskController {
    private static final Logger logger = LoggerFactory.getLogger(ZendeskController.class);

    private ZendeskRestClient zendeskRestClient;

    public ZendeskController() {
        zendeskRestClient = new ZendeskRestClient();

    }

    @RequestMapping(value = "/api/v1/tickets", method = RequestMethod.GET)
    public void listAllTickets() throws JsonProcessingException {
        logger.info("GET Request made to API: /api/v1/tickets");
        zendeskRestClient.getAllTickets();


    }
}
