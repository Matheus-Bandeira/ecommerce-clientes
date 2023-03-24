package com.ecommerce.infrastructure.models;

import lombok.Data;

@Data
public class CheckoutResponseModel {

	private String result;
	private String checkout_id;
	private String clientId;
	private CheckoutDataResponseModel data;
}
