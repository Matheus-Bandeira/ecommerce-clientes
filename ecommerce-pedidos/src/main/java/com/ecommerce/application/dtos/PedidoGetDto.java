package com.ecommerce.application.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PedidoGetDto {

	private Integer numeroPedido;
	private Date dataPedido;
	private String tipoPagamento;
	private Integer qtdParcelas;
	private BigDecimal totalPedido;
	
	private String emailCliente;
	
	private List<ItemPedidoGetDto> itensPedido;
}