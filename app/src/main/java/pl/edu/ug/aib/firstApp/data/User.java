package pl.edu.ug.aib.firstApp.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

// implements Serializable -> można przesyłać między intencjami
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    public Integer id;

    // @JsonProperty -> inna nazwa w JSONie i aplikacji
    @JsonProperty("session_id")
    public String sessionId;

}
