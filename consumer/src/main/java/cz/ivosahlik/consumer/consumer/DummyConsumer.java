package cz.ivosahlik.consumer.consumer;

import cz.ivosahlik.consumer.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class DummyConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(DummyConsumer.class);
	
	@RabbitListener(queues = "q.dummy")
	public void listenDummy(DummyMessage message) {
		LOG.info("Message is {}", message);
	}
	
}
