package com.zendesk.zendesk_ticket_viewer_rest.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ZendeskAPIResponse {


        private List<Ticket> tickets;
        private MetaView meta;

        public MetaView getMeta() {
            return meta;
        }

        public void setMeta(MetaView meta) {
            this.meta = meta;
         }

    public List<Ticket> getTickets() {
            return tickets;
        }

        public void setTickets(List<Ticket> tickets) {
            this.tickets = tickets;
        }


}
