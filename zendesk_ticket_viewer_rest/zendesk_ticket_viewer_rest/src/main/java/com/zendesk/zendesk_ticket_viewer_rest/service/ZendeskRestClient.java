package com.zendesk.zendesk_ticket_viewer_rest.service;

import com.zendesk.zendesk_ticket_viewer_rest.controller.ZendeskController;
import com.zendesk.zendesk_ticket_viewer_rest.view.Tickets;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.Charset;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class ZendeskRestClient {
    private static final Logger logger = LoggerFactory.getLogger(ZendeskRestClient.class);

    public static final String REST_SERVICE_URL = "https://zcczendeskcodingchallenge3911.zendesk.com/api/v2/tickets.json?page[size]=8";
    public static final String username = "bhatia.di@northeastern.edu";
    public static final String password = "ZendeskCodingChallenge";

    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

    public ResponseEntity<Object> getAllTickets() {

        RestTemplate restTemplate = new RestTemplate();
        logger.info("----- Making an Zendesk API call------");
        ResponseEntity<Object> responseEntity = restTemplate.exchange
                (REST_SERVICE_URL, HttpMethod.GET, new HttpEntity<Object>(createHeaders(username, password)), Object.class);
        logger.info(responseEntity.toString());
        return responseEntity;


    }





}