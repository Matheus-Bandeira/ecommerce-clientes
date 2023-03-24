package com.ecommerce.application.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemPedidoGetDto {

	private Integer id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Integer quantidade;
}
