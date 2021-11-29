package com.zendesk.zendesk_ticket_viewer_rest.service;

import com.zendesk.zendesk_ticket_viewer_rest.config.ZendeskProperties;
import com.zendesk.zendesk_ticket_viewer_rest.exception.ClientException;
import com.zendesk.zendesk_ticket_viewer_rest.exception.ServiceException;
import com.zendesk.zendesk_ticket_viewer_rest.utils.APIEndPoints;
import com.zendesk.zendesk_ticket_viewer_rest.view.ZendeskDetailedTicketResponse;
import com.zendesk.zendesk_ticket_viewer_rest.view.ZendeskMultiTicketAPIResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class ZendeskRestService {


    private final RestTemplate restTemplate = new RestTemplate();
    private final ZendeskProperties zendeskProperties;



    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

    public ZendeskMultiTicketAPIResponse getAllTickets(Map<String, String> requestParameters) throws ClientException, ServiceException {

        log.info("----- Making an Zendesk API call :: getAllTickets ------");
        log.info("Zendesk Properties: {}", zendeskProperties.getUrl());

        String lastSegmentURL = APIEndPoints.convertRawURLToZendeskURL(requestParameters);

        try {

            ResponseEntity<ZendeskMultiTicketAPIResponse> responseEntity = restTemplate.exchange
                    (zendeskProperties.getUrl() + lastSegmentURL, HttpMethod.GET,
                            new HttpEntity<ZendeskMultiTicketAPIResponse>(createHeaders(zendeskProperties.getUsername(), zendeskProperties.getPassword())),
                            ZendeskMultiTicketAPIResponse.class);



            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                log.info("----------- Get Tickets Response fetched. ------------");

                ZendeskMultiTicketAPIResponse response = responseEntity.getBody();

                if (response !=null) response.setTickets(responseEntity.getBody().getTickets().stream().filter(ticket -> ticket.isPublic()).collect(Collectors.toList()));

                return response;
            } else {
                // TODO Exception. get message

                throw new ClientException("Could not make connection with the Zendesk API");
            }


        } catch (Exception e) {
            throw new ServiceException("Request failed with an error");
        }




    }


    public ZendeskDetailedTicketResponse getDetailedTicket(String ticketId) throws ClientException, ServiceException {
        log.info("----- Making an Zendesk API call :: getAllTickets ------");

        String lastSegmentURL = APIEndPoints.convertRawURLToZendeskDetailedTicketURL(ticketId);

        try {

            ResponseEntity<ZendeskDetailedTicketResponse> responseEntity = restTemplate.exchange
                    (zendeskProperties.getUrl() + lastSegmentURL, HttpMethod.GET,
                            new HttpEntity<ZendeskMultiTicketAPIResponse>(createHeaders(zendeskProperties.getUsername(), zendeskProperties.getPassword())),
                            ZendeskDetailedTicketResponse.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                log.info("----------- Get Detailed Ticket Response fetched. ------------");


                return responseEntity.getBody();
            } else {
                // TODO Exception. get message

                throw new ClientException("Could not make connection with the Zendesk API");
            }


        } catch (Exception e) {
            throw new ServiceException("Request failed with an error");
        }



    }
}