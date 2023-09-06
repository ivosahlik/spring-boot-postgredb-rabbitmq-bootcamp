package cz.ivosahlik.consumer.consumer;

import cz.ivosahlik.consumer.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AnotherDummyConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(AnotherDummyConsumer.class);

	@RabbitListener(
			bindings = @QueueBinding(value = @Queue(name = "q.another-dummy", durable = "true"),
			exchange = @Exchange(name = "x.another-dummy", type = ExchangeTypes.FANOUT, durable = "true"),
			key = "routing-key",
			ignoreDeclarationExceptions = "true"))
	public void listenDummy(DummyMessage message) {
		LOG.info("Message is {}", message);
	}

}
