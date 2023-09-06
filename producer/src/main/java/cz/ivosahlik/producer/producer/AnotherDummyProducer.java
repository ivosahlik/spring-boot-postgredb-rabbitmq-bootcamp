package cz.ivosahlik.producer.producer;

import cz.ivosahlik.producer.entity.DummyMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnotherDummyProducer {

	private final RabbitTemplate rabbitTemplate;
	
	public void sendDummy(DummyMessage message) {
		rabbitTemplate.convertAndSend("x.another-dummy", "", message);
	}
	
}
