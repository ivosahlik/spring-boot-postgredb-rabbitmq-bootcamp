package cz.ivosahlik.consumer.consumer;

import cz.ivosahlik.consumer.repository.UploadFileRepository;
import cz.ivosahlik.domain.FileDB;
import cz.ivosahlik.domain.FileStatus;
import cz.ivosahlik.domain.MetadataMessage;
import cz.ivosahlik.exception.FileUploadConsumerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileUploadConsumer {

    private final UploadFileRepository uploadFileRepository;

    @RabbitListener(
            bindings = @QueueBinding(value = @Queue(name = "q.upload_file", durable = "true"),
                    exchange = @Exchange(name = "x.upload_file", type = ExchangeTypes.FANOUT, durable = "true"),
                    key = "routing-key",
                    ignoreDeclarationExceptions = "true"))
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
