package com.zendesk.zendesk_ticket_viewer_rest.controller;

import com.zendesk.zendesk_ticket_viewer_rest.ZendeskTicketViewerRestApplication;
import com.zendesk.zendesk_ticket_viewer_rest.service.ZendeskRestClient;
import com.zendesk.zendesk_ticket_viewer_rest.view.Tickets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ZendeskController {
    private static final Logger logger = LoggerFactory.getLogger(ZendeskController.class);

    private ZendeskRestClient zendeskRestClient;

    public ZendeskController() {
        zendeskRestClient = new ZendeskRestClient();

    }

    @RequestMapping(value = "/api/v1/tickets", method = RequestMethod.GET)
    public ResponseEntity<Object> listAllTickets() {
        logger.info("GET Request made to API: /api/v1/tickets");

        return new ResponseEntity<>(zendeskRestClient.getAllTickets(), HttpStatus.OK);
    }
}
