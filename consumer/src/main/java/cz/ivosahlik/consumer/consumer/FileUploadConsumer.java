package cz.ivosahlik.consumer.consumer;

import cz.ivosahlik.consumer.service.FileService;
import cz.ivosahlik.domain.MetadataMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FileUploadConsumer {

    private final FileService fileService;

    @RabbitListener(
            bindings = @QueueBinding(value = @Queue(name = "q.upload_file", durable = "true"),
                    exchange = @Exchange(name = "x.upload_file", type = ExchangeTypes.FANOUT, durable = "true"),
                    key = "routing-key",
                    ignoreDeclarationExceptions = "true"))
    public void uploadFile(MetadataMessage message) {
        fileService.uploadFile(message);
    }
}
