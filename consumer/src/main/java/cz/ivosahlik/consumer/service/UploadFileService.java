package cz.ivosahlik.consumer.service;

import cz.ivosahlik.consumer.repository.UploadFileRepository;
import cz.ivosahlik.domain.FileDB;
import cz.ivosahlik.domain.FileStatus;
import cz.ivosahlik.domain.MetadataMessage;
import cz.ivosahlik.exception.FileUploadConsumerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UploadFileService implements FileService {

    private final UploadFileRepository uploadFileRepository;

    @Override
    public void uploadFile(MetadataMessage message) {
        if (message.getId().isEmpty()) {
            log.error("Message is empty!");
            return;
        }

        Optional<FileDB> byId = uploadFileRepository.findById(message.getId());
        if (byId.isEmpty()) {
            log.error("File by id: {} could not be found!", message.getId());
            throw new FileUploadConsumerException("File by id: " + message.getId() + " could not be found!");
        }

        FileDB fileDB = byId.get();
        fileDB.setStatus(FileStatus.PROCESSING);
        uploadFileRepository.save(fileDB);
    }
}
