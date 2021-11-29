package com.zendesk.zendesk_ticket_viewer_rest.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ZendeskDetailedTicketResponse {
    Ticket ticket;
}
