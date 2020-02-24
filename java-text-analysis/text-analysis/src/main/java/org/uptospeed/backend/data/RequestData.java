package org.uptospeed.backend.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class RequestData {
    private String sentence;
}
