package com.ecommerce.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.interfaces.IPedidoDomainService;
import com.ecommerce.domain.models.ItemPedido;
import com.ecommerce.domain.models.Pedido;
import com.ecommerce.domain.models.Produto;
import com.ecommerce.infrastructure.repositories.IItemPedidoRepository;
import com.ecommerce.infrastructure.repositories.IPedidoRepository;
import com.ecommerce.infrastructure.repositories.IProdutoRepository;

@Service
public class PedidoDomainService implements IPedidoDomainService{

	@Autowired
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	private IItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private IProdutoRepository produtoRepository;

	@Override
	public void save(Pedido pedido, List<ItemPedido> itensPedido) throws Exception {
		
		pedidoRepository.save(pedido);	
		
		for(ItemPedido item : itensPedido) {
			Produto produto = produtoRepository.findById(item.getProdutoId()).get();
			item.setProduto(produto);
			item.setPedido(pedido);
			item.setPrecoUnitario(produto.getPreco());
			
			itemPedidoRepository.save(item);
		}	
	}

	@Override
	public List<Pedido> findByCliente(String email) throws Exception {		
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		for(Pedido pedido : pedidoRepository.findAllByEmailCliente(email)) {
			pedido.setItensPedido(itemPedidoRepository.findAllByPedido(pedido));
			pedidos.add(pedido);
		}

		return pedidos;
	}
}
