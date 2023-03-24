package com.ecommerce.domain.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idItemPedido;

	@Column(nullable = false)
	private Integer quantidade;

	@Column(nullable = false, precision = 18, scale = 2)
	private BigDecimal precoUnitario;

	@ManyToOne
	@JoinColumn(name = "pedidoId", nullable = false)
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "produtoId", nullable = false)
	private Produto produto;

	@Transient
	private Integer produtoId;
}
