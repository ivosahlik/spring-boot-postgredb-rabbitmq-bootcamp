package cz.ivosahlik.consumer.consumer;

import java.util.concurrent.TimeUnit;

import cz.ivosahlik.consumer.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Service
public class SingleActiveConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(SingleActiveConsumer.class);

	@RabbitListener(queues = "q.single", concurrency = "5")
	public void listenDummy(DummyMessage message) throws InterruptedException {
		LOG.info("Consuming {}", message);
		TimeUnit.SECONDS.sleep(1);
	}

}
