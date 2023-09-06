package cz.ivosahlik.producer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvoicePaidMessage {

	private String invoiceNumber;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate paidDate;

	private String paymentNumber;

}
