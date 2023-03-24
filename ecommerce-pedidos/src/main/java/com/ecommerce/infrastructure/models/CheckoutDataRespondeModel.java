package com.ecommerce.infrastructure.models;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckoutDataRespondeModel {

	private BigDecimal amount;
	private Date dueAt;
	private Integer installments;
}
