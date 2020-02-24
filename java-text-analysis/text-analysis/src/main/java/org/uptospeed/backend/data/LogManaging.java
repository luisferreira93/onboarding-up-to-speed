package org.uptospeed.backend.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public @Data class TextPhrase {

    @Id
    @GeneratedValue
    @Column(name = "text_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "text")
    private String text;

}
