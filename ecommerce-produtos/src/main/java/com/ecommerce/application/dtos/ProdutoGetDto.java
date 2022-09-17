package com.ecommerce.application.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoGetDto {

	private Integer id;
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
	private String descricao;
	private CategoriaGetDto categoria;

}
