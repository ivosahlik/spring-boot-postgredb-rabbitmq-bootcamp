package cz.ivosahlik.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DummyMessage {

	private String content;
	
	private int publishOrder;

}
