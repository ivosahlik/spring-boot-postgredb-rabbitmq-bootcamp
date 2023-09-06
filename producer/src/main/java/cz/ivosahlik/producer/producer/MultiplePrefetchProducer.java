package cz.ivosahlik.producer.producer;

import cz.ivosahlik.producer.entity.DummyMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@RequiredArgsConstructor
@Service
public class MultiplePrefetchProducer {

	private final RabbitTemplate rabbitTemplate;
	
	public void simulateTransaction() {
		for (int i = 0; i < 20_000; i++) {
			var message = new DummyMessage("Transaction " + LocalTime.now(), i);
			rabbitTemplate.convertAndSend("x.transaction", "", message);
		}
	}
	
	public void simulateScheduler() {
		for (int i = 0; i < 200; i++) {
			var message = new DummyMessage("Scheduler " + LocalTime.now(), i);
			rabbitTemplate.convertAndSend("x.scheduler", "", message);
		}
	}
}
