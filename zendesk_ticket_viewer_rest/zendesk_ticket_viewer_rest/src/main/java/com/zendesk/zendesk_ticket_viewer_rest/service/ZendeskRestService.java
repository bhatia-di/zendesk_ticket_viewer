package com.zendesk.zendesk_ticket_viewer_rest.service;

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

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class ZendeskRestService {

    public static final String REST_SERVICE_URL = "https://zcczendeskcodingchallenge3911.zendesk.com";
    public static final String username = "bhatia.di@northeastern.edu";
    public static final String password = "ZendeskCodingChallenge";
    private final RestTemplate restTemplate = new RestTemplate();



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

        String lastSegmentURL = APIEndPoints.convertRawURLToZendeskURL(requestParameters);

        try {

            ResponseEntity<ZendeskMultiTicketAPIResponse> responseEntity = restTemplate.exchange
                    (REST_SERVICE_URL + lastSegmentURL, HttpMethod.GET,
                            new HttpEntity<ZendeskMultiTicketAPIResponse>(createHeaders(username, password)),
                            ZendeskMultiTicketAPIResponse.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                log.info("----------- Get Tickets Response fetched. ------------");

                ZendeskMultiTicketAPIResponse response = responseEntity.getBody();

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
                    (REST_SERVICE_URL + lastSegmentURL, HttpMethod.GET,
                            new HttpEntity<ZendeskMultiTicketAPIResponse>(createHeaders(username, password)),
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