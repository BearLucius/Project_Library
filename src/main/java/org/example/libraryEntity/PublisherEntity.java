package org.example.libraryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PublisherEntity {
    private String namePublisher;
    private String cityPublisher;

    public PublisherEntity() {
    }
}