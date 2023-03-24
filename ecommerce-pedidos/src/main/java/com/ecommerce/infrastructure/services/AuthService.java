package com.ecommerce.infrastructure.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.infrastructure.interfaces.IAuthService;
import com.ecommerce.infrastructure.models.AuthRequestModel;
import com.ecommerce.infrastructure.models.AuthResponseModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

	@Value("${api.pagamentos.uri}")
	private String uri;

	@Override
	public AuthResponseModel create(AuthRequestModel model) throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		AuthResponseModel response = restTemplate.postForEntity(uri + "/api/Auth", model, AuthResponseModel.class)
				.getBody();
		

		return response;
	}

}
