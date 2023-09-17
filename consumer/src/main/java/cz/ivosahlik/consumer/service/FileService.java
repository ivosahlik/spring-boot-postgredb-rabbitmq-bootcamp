package cz.ivosahlik.consumer.service;

import cz.ivosahlik.domain.MetadataMessage;

@FunctionalInterface
public interface FileService {

    void uploadFile(MetadataMessage message);

}
