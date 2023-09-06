package cz.ivosahlik.consumer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvoiceCancelledMessage {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate cancelDate;
	
	private String invoiceNumber;
	
	private String reason;

}
