package com.ecommerce.controlllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Pedidos")
@RestController
public class PedidosController {

	@ApiOperation("Serviço para cadastro de pedido")
	@PostMapping("v1/pedidos")
	public ResponseEntity<String> post() {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@ApiOperation("Serviço para cosulta de pedidos")
	@GetMapping("v1/pedidos")
	public ResponseEntity<String> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
