package cz.ivosahlik.domain;

import lombok.*;

@Data
public class ResponseMessage {

    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

}