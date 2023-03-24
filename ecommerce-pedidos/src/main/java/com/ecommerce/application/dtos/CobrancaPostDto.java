package com.ecommerce.application.dtos;

import lombok.Data;

@Data
public class CobrancaPostDto {

	private String numeroCartao;
	private String nomeTitular;
	private String cpfTitular;
	private Integer mesVencimento;
	private Integer anoVencimento;
	private Integer codigoSeguranca;
}
