package com.zendesk.zendesk_ticket_viewer_rest.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaView {

    @JsonProperty("has_more")
    private boolean isMore;

    @JsonProperty("before_cursor")
    private String before;

    @JsonProperty("after_cursor")
    private String after;

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
