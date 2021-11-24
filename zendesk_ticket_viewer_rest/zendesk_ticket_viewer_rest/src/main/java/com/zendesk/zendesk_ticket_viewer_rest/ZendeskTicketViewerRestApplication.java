package com.zendesk.zendesk_ticket_viewer_rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZendeskTicketViewerRestApplication {
	private static final Logger logger = LoggerFactory.getLogger(ZendeskTicketViewerRestApplication.class);


	public static void main(String[] args) {
		logger.info("-------------Zendesk Ticket Viewer Initiated-------------------");
		SpringApplication.run(ZendeskTicketViewerRestApplication.class, args);
	}

}
