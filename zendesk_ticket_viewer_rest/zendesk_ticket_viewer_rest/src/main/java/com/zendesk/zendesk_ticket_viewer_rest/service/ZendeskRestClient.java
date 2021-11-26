package com.zendesk.zendesk_ticket_viewer_rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.zendesk.zendesk_ticket_viewer_rest.view.Ticket;
import com.zendesk.zendesk_ticket_viewer_rest.view.ZendeskAPIResponse;
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
    private ObjectMapper objectMapper;
    RestTemplate restTemplate;

    public ZendeskRestClient() {

        objectMapper = new ObjectMapper().registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
        restTemplate = new RestTemplate();

    }



    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

    public ResponseEntity getAllTickets() {

        logger.info("----- Making an Zendesk API call------");

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange
                    (REST_SERVICE_URL, HttpMethod.GET, new HttpEntity<String>(createHeaders(username, password)), String.class);

            if (responseEntity.getStatusCodeValue() == 200) {

                ZendeskAPIResponse response = objectMapper.readValue(responseEntity.getBody(), ZendeskAPIResponse.class);

                return new ResponseEntity(response, HttpStatus.OK);
            } else {

                return new ResponseEntity("Could not make connection with the Zendesk API", HttpStatus.BAD_REQUEST);
            }


        } catch (JsonProcessingException e) {
            return  new ResponseEntity("Could not parse the response ", HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
                return  new ResponseEntity("Request failed with an error ", HttpStatus.INTERNAL_SERVER_ERROR);
        }




    }





}