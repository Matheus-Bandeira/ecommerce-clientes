package com.ecommerce.infrastructure.interfaces;

import com.ecommerce.infrastructure.models.CheckoutRequestModel;
import com.ecommerce.infrastructure.models.CheckoutResponseModel;

public interface ICheckoutService {

	CheckoutResponseModel create(CheckoutRequestModel model, String accessToken) throws Exception;
}
