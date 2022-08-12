package com.ecommerce.models;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(collection = "clientes")
public class Cliente {

	@Id
	private String _id;
	private String nome;

	@Indexed(unique = true)
	private String telefone;

	@Indexed(unique = true)
	private String email;

	@JsonIgnore
	private String senha;
	private Instant cadastradoEm;
	private Instant atualizadoEm;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

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

	public Instant getCadastradoEm() {
		return cadastradoEm;
	}

	public void setCadastradoEm(Instant cadastradoEm) {
		this.cadastradoEm = cadastradoEm;
	}

	public Instant getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(Instant atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

}
