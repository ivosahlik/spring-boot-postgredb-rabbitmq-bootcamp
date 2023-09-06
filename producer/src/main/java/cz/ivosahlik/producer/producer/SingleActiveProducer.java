package cz.ivosahlik.producer.producer;

import cz.ivosahlik.producer.entity.DummyMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SingleActiveProducer {

	private final RabbitTemplate rabbitTemplate;

	public void sendDummy() {
		for (int i = 0; i < 10_000; i++) {
			var message = new DummyMessage("Message " + i, i);
			rabbitTemplate.convertAndSend("x.single", "", message);
		}
	}
}
