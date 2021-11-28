package com.zendesk.zendesk_ticket_viewer_rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.zendesk.zendesk_ticket_viewer_rest.utils.APIEndPoints;
import com.zendesk.zendesk_ticket_viewer_rest.view.Ticket;
import com.zendesk.zendesk_ticket_viewer_rest.view.ZendeskAPIResponse;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZendeskRestClient {
    private static final Logger logger = LoggerFactory.getLogger(ZendeskRestClient.class);

    public static final String REST_SERVICE_URL = "https://zcczendeskcodingchallenge3911.zendesk.com";
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

    public ResponseEntity getAllTickets(Map<String, String> requestParameters) {

        logger.info("----- Making an Zendesk API call------");

        String prefixURL = Objects.isNull(requestParameters.get("page")) && Objects.isNull(requestParameters.get("pageLink"))
                ? APIEndPoints.getZendeskTicketsURLWithPageSize
                .replace("{pageSize}", String.valueOf(requestParameters.get("pageSize")))
                : APIEndPoints.getZendeskTicketsURLWithPageLink
                .replace("{pageLink}", requestParameters.get("pageLink"))
                .replace("{page}", requestParameters.get("page"));
        

        try {
            ResponseEntity<ZendeskAPIResponse> responseEntity = restTemplate.exchange
                    (REST_SERVICE_URL + prefixURL, HttpMethod.GET,
                            new HttpEntity<ZendeskAPIResponse>(createHeaders(username, password)),
                            ZendeskAPIResponse.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {

                ZendeskAPIResponse response = responseEntity.getBody();

                return new ResponseEntity(response, HttpStatus.OK);
            } else {

                return new ResponseEntity("Could not make connection with the Zendesk API", HttpStatus.BAD_REQUEST);
            }


        } catch (Exception e) {
                return  new ResponseEntity("Request failed with an error ", HttpStatus.INTERNAL_SERVER_ERROR);
        }




    }





}