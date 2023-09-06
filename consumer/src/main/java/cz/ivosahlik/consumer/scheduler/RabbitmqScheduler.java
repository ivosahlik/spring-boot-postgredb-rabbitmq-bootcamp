package cz.ivosahlik.consumer.scheduler;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@EnableScheduling
public class RabbitmqScheduler {

	private static final Logger LOG = LoggerFactory.getLogger(RabbitmqScheduler.class);
	
	private final RabbitListenerEndpointRegistry registry;
	
	@Scheduled(cron = "0 6 8 * * *")
	public void stopAll() {
		registry.getListenerContainers().forEach(c -> {
			LOG.info("Stopping listener container {}", c);
			c.stop();
		});
	}

	@Scheduled(cron = "0 8 8 * * *")
	public void startAll() {
		registry.getListenerContainers().forEach(c -> {
			LOG.info("Starting listener container {}", c);
			c.start();
		});
	}

}
