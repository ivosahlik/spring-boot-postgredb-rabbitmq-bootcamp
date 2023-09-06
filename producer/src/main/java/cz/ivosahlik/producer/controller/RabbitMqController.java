package cz.ivosahlik.producer.controller;

import cz.ivosahlik.producer.entity.Dummy;
import cz.ivosahlik.producer.entity.DummyMessage;
import cz.ivosahlik.producer.producer.AnotherDummyProducer;
import cz.ivosahlik.producer.repository.DummyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class RabbitMqController {

	private final AnotherDummyProducer producer;

	private final DummyRepository dummyRepository;

	// http://localhost:8080/api/v1/test/another-dummy/1
	@GetMapping("/test/another-dummy/{id}")
	public String testAnotherDummyAPI(@PathVariable("id") int id) {
		Optional<Dummy> dummy = dummyRepository.findById(id);

		if(dummy.isPresent()) {
			var dummyMessage = new DummyMessage(dummy.get().getContent(), dummy.get().getPublishOrder());
			producer.sendDummy(dummyMessage);
			return "Success";
		} else {
			return null;
		}
	}
}
