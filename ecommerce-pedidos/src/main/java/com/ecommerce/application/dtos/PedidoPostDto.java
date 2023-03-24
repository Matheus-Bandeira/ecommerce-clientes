package com.ecommerce.application.dtos;

import java.util.List;

import lombok.Data;

@Data
public class PedidoPostDto {

	private List<ItemPedidoPostDto> itensPedido;
	private String tipoPagamento;
	private Integer qtdParcelas;
	private String valor;

	private CobrancaPostDto cobranca;
}
