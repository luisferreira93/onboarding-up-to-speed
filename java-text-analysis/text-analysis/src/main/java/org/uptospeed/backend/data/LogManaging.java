package org.uptospeed.backend.data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class LogManaging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "text_id", updatable = false, nullable = false)
    private Long textId;
    @Column(name = "text_phrase")
    private String textPhrase;
    @Column(name = "request_time")
    private Date requestTime;

    public Long getTextId() {
        return textId;
    }

    public void setTextId(Long textId) {
        this.textId = textId;
    }

    public String getTextPhrase() {
        return textPhrase;
    }

    public void setTextPhrase(String textPhrase) {
        this.textPhrase = textPhrase;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogManaging that = (LogManaging) o;
        return Objects.equals(textId, that.textId) &&
                Objects.equals(textPhrase, that.textPhrase) &&
                Objects.equals(requestTime, that.requestTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textId, textPhrase, requestTime);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LogManaging;
    }

    @Override
    public String toString() {
        return "LogManaging{" +
                "textId=" + textId +
                ", textPhrase='" + textPhrase + '\'' +
                ", requestTime=" + requestTime +
                '}';
    }
}