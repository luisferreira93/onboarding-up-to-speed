package org.uptospeed.backend.data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class LogManaging
{
    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "text")
    private String text;

    public Long getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setText(final String text) {
        this.text = text;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LogManaging)) {
            return false;
        }
        final LogManaging other = (LogManaging)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        Label_0065: {
            if (this$id == null) {
                if (other$id == null) {
                    break Label_0065;
                }
            }
            else if (this$id.equals(other$id)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$text = this.getText();
        final Object other$text = other.getText();
        if (this$text == null) {
            if (other$text == null) {
                return true;
            }
        }
        else if (this$text.equals(other$text)) {
            return true;
        }
        return false;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LogManaging;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        final Object $text = this.getText();
        result = result * 59 + (($text == null) ? 43 : $text.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LogManaging(id=" + this.getId() + ", text=" + this.getText() + ")";
    }
}