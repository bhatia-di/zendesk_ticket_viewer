package com.zendesk.zendesk_ticket_viewer_rest.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter

public class ZendeskMultiTicketAPIResponse {


        private List<Ticket> tickets;
        private MetaView meta;




}
