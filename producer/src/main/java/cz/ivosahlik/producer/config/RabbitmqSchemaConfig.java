package cz.ivosahlik.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqSchemaConfig {

	@Bean
	public Declarables rabbitmqSchema() {
		return new Declarables(
				new FanoutExchange("x.upload_file", true, false),
				new Queue("q.upload_file"),
				new Binding("q.upload_file",
						DestinationType.QUEUE, "x.upload_file", "", null));
	}
}
