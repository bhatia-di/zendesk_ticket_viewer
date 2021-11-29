package com.zendesk.zendesk_ticket_viewer_rest.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Ticket {
    private long id;
    private boolean allow_attachments;
    private boolean allow_channelback;
    private String assignee_email;
    private long assignee_id;
    private String[] attribute_value_ids;
    private long brand_id;
    private String[] collaborator_ids;
    private LocalDateTime created_at;
    private String description;
    private LocalDateTime due_at;
    private String[] email_cc_ids;
    private long[] follower_ids;
    private long[] followup_ids;
    private boolean is_public;
    private MetaView meta;
    // Allowed values are "urgent", "high", "normal", or "low".
    private String priority;
    private String raw_subject;
    private String recipient;
    private Object requester;
    private Object satisfaction_rating;
    private String status;
    private String subject;
    private String[] tags;
    private String type;
    private LocalDateTime updated_at;


}
