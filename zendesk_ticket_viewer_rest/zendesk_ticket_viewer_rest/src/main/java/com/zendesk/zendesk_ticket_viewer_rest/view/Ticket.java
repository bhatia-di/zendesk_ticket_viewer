package com.zendesk.zendesk_ticket_viewer_rest.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAllow_attachments() {
        return allow_attachments;
    }

    public void setAllow_attachments(boolean allow_attachments) {
        this.allow_attachments = allow_attachments;
    }

    public boolean isAllow_channelback() {
        return allow_channelback;
    }

    public void setAllow_channelback(boolean allow_channelback) {
        this.allow_channelback = allow_channelback;
    }

    public String getAssignee_email() {
        return assignee_email;
    }

    public void setAssignee_email(String assignee_email) {
        this.assignee_email = assignee_email;
    }

    public long getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(long assignee_id) {
        this.assignee_id = assignee_id;
    }

    public String[] getAttribute_value_ids() {
        return attribute_value_ids;
    }

    public void setAttribute_value_ids(String[] attribute_value_ids) {
        this.attribute_value_ids = attribute_value_ids;
    }

    public long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(long brand_id) {
        this.brand_id = brand_id;
    }

    public String[] getCollaborator_ids() {
        return collaborator_ids;
    }

    public void setCollaborator_ids(String[] collaborator_ids) {
        this.collaborator_ids = collaborator_ids;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDue_at() {
        return due_at;
    }

    public void setDue_at(LocalDateTime due_at) {
        this.due_at = due_at;
    }

    public String[] getEmail_cc_ids() {
        return email_cc_ids;
    }

    public void setEmail_cc_ids(String[] email_cc_ids) {
        this.email_cc_ids = email_cc_ids;
    }

    public long[] getFollower_ids() {
        return follower_ids;
    }

    public void setFollower_ids(long[] follower_ids) {
        this.follower_ids = follower_ids;
    }

    public long[] getFollowup_ids() {
        return followup_ids;
    }

    public void setFollowup_ids(long[] followup_ids) {
        this.followup_ids = followup_ids;
    }

    public boolean isIs_public() {
        return is_public;
    }

    public void setIs_public(boolean is_public) {
        this.is_public = is_public;
    }

    public MetaView getMeta() {
        return meta;
    }

    public void setMeta(MetaView meta) {
        this.meta = meta;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRaw_subject() {
        return raw_subject;
    }

    public void setRaw_subject(String raw_subject) {
        this.raw_subject = raw_subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Object getRequester() {
        return requester;
    }

    public void setRequester(Object requester) {
        this.requester = requester;
    }

    public Object getSatisfaction_rating() {
        return satisfaction_rating;
    }

    public void setSatisfaction_rating(Object satisfaction_rating) {
        this.satisfaction_rating = satisfaction_rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
