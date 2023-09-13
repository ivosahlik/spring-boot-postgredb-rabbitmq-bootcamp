package cz.ivosahlik.producer.producer;

import cz.ivosahlik.domain.MetadataMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FileProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendFile(MetadataMessage message) {
        rabbitTemplate.convertAndSend("x.upload_file", "", message);
    }

}
