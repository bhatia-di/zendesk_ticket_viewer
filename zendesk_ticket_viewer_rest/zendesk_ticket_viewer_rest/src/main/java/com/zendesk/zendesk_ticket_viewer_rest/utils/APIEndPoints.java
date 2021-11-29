package com.zendesk.zendesk_ticket_viewer_rest.utils;

import java.util.Map;
import java.util.Objects;

public class APIEndPoints {

    public static String getZendeskTicketsURLWithPageSize = "/api/v2/tickets.json?page[size]={pageSize}";
    public static String getZendeskTicketsURLWithPageLink = "/api/v2/tickets.json?page[size]={pageSize}&page[{pageLink}]={page}";
    public static String getZendeskDetailedTicketURL = "/api/v2/tickets/{ticket_id}";


    public static String convertRawURLToZendeskURL (Map<String, String> requestParameters) {
        return Objects.isNull(requestParameters.get("page")) && Objects.isNull(requestParameters.get("pageLink"))
                ? getZendeskTicketsURLWithPageSize
                .replace("{pageSize}", String.valueOf(requestParameters.get("pageSize")))
                : getZendeskTicketsURLWithPageLink
                .replace("{pageSize}", String.valueOf(requestParameters.get("pageSize")))
                .replace("{pageLink}", requestParameters.get("pageLink"))
                .replace("{page}", requestParameters.get("page"));



    }

    public static String convertRawURLToZendeskDetailedTicketURL(String ticketId) {
        return getZendeskDetailedTicketURL.replace("{ticket_id}", ticketId);
    }
}
