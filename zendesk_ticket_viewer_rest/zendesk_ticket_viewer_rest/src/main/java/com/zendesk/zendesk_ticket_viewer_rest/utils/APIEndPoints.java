package com.zendesk.zendesk_ticket_viewer_rest.utils;

public class APIEndPoints {

    public static String getZendeskTicketsURLWithPageSize = "/api/v2/tickets.json?page[size]={pageSize}";
    public static String getZendeskTicketsURLWithPageLink = "/api/v2/tickets.json?page[size]={pageSize}&page[{pageLink}]={page}";

}
