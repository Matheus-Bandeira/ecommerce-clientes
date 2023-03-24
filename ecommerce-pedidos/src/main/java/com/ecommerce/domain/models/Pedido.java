package com.ecommerce.domain.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idPedido;

	@Column(nullable = false)
	private String tipoPagamento;

	@Column(nullable = false)
	private Integer qtdParcelas;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataPedido;

	@Column(nullable = false, precision = 18, scale = 2)
	private BigDecimal valorTotal;

	@Column(nullable = false)
	private String emailCliente;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itensPedido;
}
