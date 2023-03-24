package com.ecommerce.infrastructure.models;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class CheckoutDataResponseModel {

	private BigDecimal amount;
	private Date dueAt;
	private Integer installments;
}
