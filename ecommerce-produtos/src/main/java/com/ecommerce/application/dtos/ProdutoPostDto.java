package com.ecommerce.application.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProdutoPostDto {

	@Size(min = 6, max = 150, message = "Nome deve ter de 6 a 150 caracteres.")
	@NotBlank(message = "Nome é obrigatório.")
	private String nome;

	@Min(value = 1, message = "Preço deve ser maior ou igual a 1.")
	private BigDecimal preco;

	@Min(value = 1, message = "Quantidade deve ser maior ou igual a 1.")
	private Integer quantidade;

	@Size(min = 6, max = 150, message = "Descrição deve ter de 6 a 150 caracteres.")
	@NotBlank(message = "Descrição é obrigatório.")
	private String descricao;

	@Min(value = 1, message = "Id da categoria deve ser maior ou igual a 1.")
	private Integer categoria_id;

}
