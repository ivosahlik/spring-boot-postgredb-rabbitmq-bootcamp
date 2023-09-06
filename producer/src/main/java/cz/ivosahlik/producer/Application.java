package cz.ivosahlik.producer;

import cz.ivosahlik.producer.entity.DummyMessage;
import cz.ivosahlik.producer.producer.AnotherDummyProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private final AnotherDummyProducer producer;

	@Override
	public void run(String... args) throws Exception {
		var dummyMessage = new DummyMessage("Just a dummy message", 10);
		producer.sendDummy(dummyMessage);
	}

}
