package com.zendesk.zendesk_ticket_viewer_rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ZendeskWebContext {

    @Bean("restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
