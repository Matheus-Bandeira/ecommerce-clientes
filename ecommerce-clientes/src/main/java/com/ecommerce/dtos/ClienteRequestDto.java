package com.ecommerce.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class ClienteRequestDto {

	@Size(min = 6, max = 150, message = "Nome do cliente deve ser de 6 a 150 caracteres")
	@NotBlank(message = "Nome do cliente é obrigatório")
	private String nome;

	@Pattern(regexp = "(^$|[0-9]{11})", message = "Telefone deve ter 11 dígitos numéricos")
	@NotBlank(message = "Telefone do cliente é obrigatório")
	private String telefone;

	@Email(message = "Email do cliente é inválido")
	@NotBlank(message = "Email do cliente é obrigatório")
	private String email;

	@Size(min = 8, max = 20, message = "Senha do cliente de ser de 8 a 20 caracteres")
	@NotBlank(message = "Senha do cliente é obrigatória")
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
