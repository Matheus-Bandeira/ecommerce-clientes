package com.ecommerce.infrastructure.interfaces;

import com.ecommerce.infrastructure.models.AuthRequestModel;
import com.ecommerce.infrastructure.models.AuthResponseModel;

public interface IAuthService {

	AuthResponseModel create(AuthRequestModel model) throws Exception;
}
