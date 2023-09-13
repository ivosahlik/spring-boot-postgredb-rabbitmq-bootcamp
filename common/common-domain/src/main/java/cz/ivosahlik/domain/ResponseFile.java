package cz.ivosahlik.domain;

import lombok.*;

@AllArgsConstructor
@Data
public class ResponseFile {
    private String name;
    private String url;
    private String type;
    private long size;
}