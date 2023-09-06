package cz.ivosahlik.producer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Dummy {

	@Id
	private int id;

	private String content;

	@Column(name = "publishorder")
	private int publishOrder;
}
