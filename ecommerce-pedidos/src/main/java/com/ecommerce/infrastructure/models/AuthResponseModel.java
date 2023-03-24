package com.ecommerce.infrastructure.models;

import java.util.Date;

import lombok.Data;

@Data
public class AuthResponseModel {

	private String accessToken;
	private Date expirationDate;
	private String client_id;
	private String name;
}
