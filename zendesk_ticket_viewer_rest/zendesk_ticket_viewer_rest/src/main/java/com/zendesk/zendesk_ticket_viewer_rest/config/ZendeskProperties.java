package com.zendesk.zendesk_ticket_viewer_rest.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter @Setter
@Configuration
public class ZendeskProperties {

    @Value("${zendesk.api.url}")
    private String url;

    @Value("${zendesk.api.username}")
    private String username;

    @Value("${zendesk.api.password}")
    private String password;


}
