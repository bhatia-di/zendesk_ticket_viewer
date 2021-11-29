package controller;

import com.zendesk.zendesk_ticket_viewer_rest.ZendeskTicketViewerRestApplication;
import com.zendesk.zendesk_ticket_viewer_rest.config.ZendeskProperties;
import com.zendesk.zendesk_ticket_viewer_rest.controller.ZendeskController;
import com.zendesk.zendesk_ticket_viewer_rest.exception.ClientException;
import com.zendesk.zendesk_ticket_viewer_rest.service.ZendeskRestService;
import com.zendesk.zendesk_ticket_viewer_rest.view.MetaView;
import com.zendesk.zendesk_ticket_viewer_rest.view.Ticket;
import com.zendesk.zendesk_ticket_viewer_rest.view.ZendeskDetailedTicketResponse;
import com.zendesk.zendesk_ticket_viewer_rest.view.ZendeskMultiTicketAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
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
    public void getAllTicketsTestWithEmptyList() throws Exception {

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
        when(restTemplate.exchange(anyString(), any(), any(), eq(ZendeskMultiTicketAPIResponse.class)))
                .thenReturn(ResponseEntity.of(Optional.of(mockZen)));
        zendeskRestService.getAllTickets(param);
        Assertions.assertTrue(zendeskRestService.getAllTickets(param).getTickets().isEmpty());





    }


    @Test
    public void getAllTicketsTestWithNonEmptyList() throws Exception {

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Ticket t = new Ticket();
        t.setId(223455);
        t.setPublic(true);
        tickets.add(t);
        MetaView metaView = new MetaView();
        metaView.setMore(false);
        metaView.setAfter("test");
        metaView.setBefore("test");

        ZendeskMultiTicketAPIResponse mockZen = new ZendeskMultiTicketAPIResponse();
        mockZen.setTickets(tickets);
        mockZen.setMeta(metaView);
        Map<String, String> param = new HashMap<>();
        param.put("pageSize", "25");
        when(restTemplate.exchange(anyString(), any(), any(), eq(ZendeskMultiTicketAPIResponse.class)))
                .thenReturn(ResponseEntity.of(Optional.of(mockZen)));

        Assertions.assertEquals(zendeskRestService.getAllTickets(param).getTickets().size(), 1);
    }


    @Test
    public void getAllTicketsTestWithWithFilteredValuesBasedOnPublicProperty() throws Exception {

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Ticket t = new Ticket();
        t.setId(223455);
        t.setPublic(true);
        Ticket t1 = new Ticket();
        t1.setId(223456);
        t1.setPublic(false);
        tickets.add(t);
        MetaView metaView = new MetaView();
        metaView.setMore(false);
        metaView.setAfter("test");
        metaView.setBefore("test");

        ZendeskMultiTicketAPIResponse mockZen = new ZendeskMultiTicketAPIResponse();
        mockZen.setTickets(tickets);
        mockZen.setMeta(metaView);
        Map<String, String> param = new HashMap<>();
        param.put("pageSize", "25");
        when(restTemplate.exchange(anyString(), any(), any(), eq(ZendeskMultiTicketAPIResponse.class)))
                .thenReturn(ResponseEntity.of(Optional.of(mockZen)));

        Assertions.assertEquals(zendeskRestService.getAllTickets(param).getTickets().size(), 1);
    }




    @Test
    public void getAllTicketsTestWith400ErrorFromZendesk() throws Exception {

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Ticket t = new Ticket();
        t.setId(223455);
        t.setPublic(true);
        tickets.add(t);
        MetaView metaView = new MetaView();
        metaView.setMore(false);
        metaView.setAfter("test");
        metaView.setBefore("test");

        ZendeskMultiTicketAPIResponse mockZen = new ZendeskMultiTicketAPIResponse();
        mockZen.setTickets(tickets);
        mockZen.setMeta(metaView);
        Map<String, String> param = new HashMap<>();
        param.put("pageSize", "25");
        when(restTemplate.exchange(anyString(), any(), any(), eq(ZendeskMultiTicketAPIResponse.class)))
                .thenReturn(new ResponseEntity(HttpStatus.BAD_REQUEST));

        Assertions.assertThrows(ClientException.class,() -> { zendeskRestService.getAllTickets(param); });
    }


}
