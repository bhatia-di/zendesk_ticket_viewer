package controller;

import com.zendesk.zendesk_ticket_viewer_rest.ZendeskTicketViewerRestApplication;
import com.zendesk.zendesk_ticket_viewer_rest.config.ZendeskProperties;
import com.zendesk.zendesk_ticket_viewer_rest.controller.ZendeskController;
import com.zendesk.zendesk_ticket_viewer_rest.service.ZendeskRestService;
import com.zendesk.zendesk_ticket_viewer_rest.view.MetaView;
import com.zendesk.zendesk_ticket_viewer_rest.view.Ticket;
import com.zendesk.zendesk_ticket_viewer_rest.view.ZendeskDetailedTicketResponse;
import com.zendesk.zendesk_ticket_viewer_rest.view.ZendeskMultiTicketAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Slf4j
@SpringBootTest(classes = {ZendeskTicketViewerRestApplication.class})
@AutoConfigureMockMvc
public class ZendeskControllerTest {
    @Autowired
    ZendeskController zendeskController;

    @InjectMocks
    private ZendeskRestService zendeskRestService;

    @Mock
    private RestTemplate restTemplate;

    @Autowired
    private MockMvc mvc;


    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        ZendeskProperties zendeskProperties = new ZendeskProperties();
        zendeskProperties.setPassword("test");
        zendeskProperties.setUrl("test");
        zendeskProperties.setUsername("test");
        zendeskRestService = new ZendeskRestService(restTemplate, zendeskProperties);
        zendeskController = new ZendeskController(zendeskRestService);

    }




    @Test
    public void getAllTicketsTest() throws Exception {

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        MetaView metaView = new MetaView();
        metaView.setMore(false);
        metaView.setAfter("test");
        metaView.setBefore("test");

        ZendeskMultiTicketAPIResponse mockZen = new ZendeskMultiTicketAPIResponse();
        mockZen.setTickets(tickets);
        mockZen.setMeta(metaView);
        Map<String, String> param = new HashMap<>();
        param.put("pageSize", "25");
        zendeskRestService.getAllTickets(param);
//        when(restTemplate.exchange(anyString(), any(), any(), eq(ZendeskMultiTicketAPIResponse.class)))
//                .thenReturn(ResponseEntity.of(Optional.of(mockZen)));

//        String response = mvc.perform(
//                        get("/api/v1/tickets")
//                                .headers( new HttpHeaders() {{
//            String auth = "username" + ":" + "password";
//            byte[] encodedAuth = Base64.encodeBase64(
//                    auth.getBytes(Charset.forName("US-ASCII")) );
//            String authHeader = "Basic " + new String( encodedAuth );
//            set( "Authorization", authHeader );
//        }})
//                                .param("pageSize", "25")
//                                )
//
//
//                .andReturn().getResponse().getContentAsString();
//        log.info("Response {}", response);


    }


}
