package cz.ivosahlik.consumer.consumer;

import java.util.concurrent.TimeUnit;

import cz.ivosahlik.consumer.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class DummyPrefetchConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(DummyPrefetchConsumer.class);
	
	@RabbitListener(queues = "q.dummy", concurrency = "2")
	public void listenDummy(DummyMessage message) throws InterruptedException {
		LOG.info("Message is {}", message);
		TimeUnit.SECONDS.sleep(20);
	}
	
}
