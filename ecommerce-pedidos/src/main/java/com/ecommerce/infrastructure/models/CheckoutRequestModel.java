package com.ecommerce.infrastructure.models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CheckoutRequestModel {

	private String number;
	private String holderName;
	private String holderDocument;
	private Integer expirationMonth;
	private Integer expirationYear;
	private Integer cvv;
	private BigDecimal amount;
	private String dueAt;
	private Integer installments;
}
