package cz.ivosahlik.consumer.consumer;

import cz.ivosahlik.consumer.repository.UploadFileRepository;
import cz.ivosahlik.domain.FileDB;
import cz.ivosahlik.domain.FileStatus;
import cz.ivosahlik.domain.MetadataMessage;
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
        log.info("Message is {}", message.getId());

        if (!message.getId().isEmpty()) {
            Optional<FileDB> byId = uploadFileRepository.findById(message.getId());
            if (byId.isPresent()) {
                FileDB fileDB = byId.get();
                fileDB.setStatus(FileStatus.PROCESSING);
                uploadFileRepository.save(fileDB);
            }
        }
    }
}
