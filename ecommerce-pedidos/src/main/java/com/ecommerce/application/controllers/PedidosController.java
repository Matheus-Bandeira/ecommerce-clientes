package com.ecommerce.application.controllers;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.application.dtos.ItemPedidoGetDto;
import com.ecommerce.application.dtos.ItemPedidoPostDto;
import com.ecommerce.application.dtos.PedidoGetDto;
import com.ecommerce.application.dtos.PedidoPostDto;
import com.ecommerce.domain.models.ItemPedido;
import com.ecommerce.domain.models.Pedido;
import com.ecommerce.domain.services.PedidoDomainService;
import com.ecommerce.infrastructure.interfaces.IAuthService;
import com.ecommerce.infrastructure.interfaces.ICheckoutService;
import com.ecommerce.infrastructure.models.AuthRequestModel;
import com.ecommerce.infrastructure.models.AuthResponseModel;
import com.ecommerce.infrastructure.models.CheckoutRequestModel;
import com.ecommerce.infrastructure.models.CheckoutResponseModel;
import com.ecommerce.infrastructure.security.TokenAuthenticationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Pedidos")
@RestController
public class PedidosController {

	@Autowired
	private IAuthService authService;

	@Autowired
	private ICheckoutService checkoutService;
	
	@Autowired
	private TokenAuthenticationService authenticationService;
	
	@Autowired
	private PedidoDomainService pedidoDomainService;

	@Value("${api.pagamentos.user.name}")
	private String name;

	@Value("${api.pagamentos.user.key}")
	private String key;

	@CrossOrigin("http://localhost:4200")
	@ApiOperation("Serviço para realização de pedidos")
	@PostMapping("/v1/pedidos")
	public ResponseEntity<PedidoGetDto> post(@Valid @RequestBody PedidoPostDto dto, HttpServletRequest request) {

		try {

			String emailCliente = getEmailCliente(request);
			
			AuthRequestModel authRequest = new AuthRequestModel();
			authRequest.setName(name);
			authRequest.setKey(key);

			AuthResponseModel authResponse = authService.create(authRequest);
			
			CheckoutRequestModel checkoutRequest = createCheckoutRequestModel(dto);
			CheckoutResponseModel checkoutResponse = checkoutService.create(checkoutRequest,
					authResponse.getAccessToken());
			
			Pedido pedido = new Pedido();
			pedido.setEmailCliente(emailCliente);
			pedido.setDataPedido(new Date());
			pedido.setQtdParcelas(checkoutResponse.getData().getInstallments());
			pedido.setTipoPagamento("Cartão de Crédido");
			pedido.setValorTotal(checkoutResponse.getData().getAmount());
			
			List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
			
			for(ItemPedidoPostDto item : dto.getItensPedido()) {
				
				ItemPedido itemPedido = new ItemPedido();
				itemPedido.setQuantidade(item.getQuantidade());
				itemPedido.setProdutoId(item.getIdProduto());
				
				itensPedido.add(itemPedido);
			}
						
			pedidoDomainService.save(pedido, itensPedido);

			PedidoGetDto pedidoGetDto = createPedidoGetDto(pedido, itensPedido);
			return ResponseEntity.status(HttpStatus.CREATED).body(pedidoGetDto);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@CrossOrigin("http://localhost:4200")
	@ApiOperation("Serviço para consulta de pedidos do cliente")
	@GetMapping("/v1/pedidos")
	public ResponseEntity<List<PedidoGetDto>> getAll(HttpServletRequest request) {

		try {

			String emailCliente = getEmailCliente(request);
			
			List<PedidoGetDto> dto = new ArrayList<PedidoGetDto>();
			for(Pedido pedido : pedidoDomainService.findByCliente(emailCliente)) {
				PedidoGetDto pedidoGetDto = createPedidoGetDto(pedido, pedido.getItensPedido());
				dto.add(pedidoGetDto);
			}
						
			return ResponseEntity.status(HttpStatus.OK).body(dto);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	private CheckoutRequestModel createCheckoutRequestModel(PedidoPostDto dto) {
		
		CheckoutRequestModel checkoutRequest = new CheckoutRequestModel();
		checkoutRequest.setNumber(dto.getCobranca().getNumeroCartao());
		checkoutRequest.setHolderName(dto.getCobranca().getNomeTitular());
		checkoutRequest.setHolderDocument(dto.getCobranca().getCpfTitular());
		checkoutRequest.setExpirationMonth(dto.getCobranca().getMesVencimento());
		checkoutRequest.setExpirationYear(dto.getCobranca().getAnoVencimento());
		checkoutRequest.setCvv(dto.getCobranca().getCodigoSeguranca());
		checkoutRequest.setAmount(new BigDecimal(dto.getValor()));
		checkoutRequest.setDueAt(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		checkoutRequest.setInstallments(dto.getQtdParcelas());
		
		return checkoutRequest;
	}

	private PedidoGetDto createPedidoGetDto(Pedido pedido, List<ItemPedido> itensPedido) {
		
		PedidoGetDto dto = new PedidoGetDto();
		
		dto.setNumeroPedido(pedido.getIdPedido());
		dto.setDataPedido(pedido.getDataPedido());
		dto.setEmailCliente(pedido.getEmailCliente());
		dto.setQtdParcelas(pedido.getQtdParcelas());
		dto.setTotalPedido(pedido.getValorTotal());
		dto.setTipoPagamento(pedido.getTipoPagamento());
		dto.setItensPedido(new ArrayList<ItemPedidoGetDto>());
		
		for(ItemPedido item : itensPedido) {
			ItemPedidoGetDto itemDto = new ItemPedidoGetDto();
			itemDto.setId(item.getIdItemPedido());
			itemDto.setNome(item.getProduto().getNome());
			itemDto.setDescricao(item.getProduto().getDescricao());
			itemDto.setPreco(item.getPrecoUnitario());
			itemDto.setQuantidade(item.getQuantidade());
			
			dto.getItensPedido().add(itemDto);
		}
		
		return dto;
	}
	
	private String getEmailCliente(HttpServletRequest request) {
		String accessToken = request.getHeader("Authorization").replace("Bearer", "").trim();
		return authenticationService.getUserFromToken(accessToken);
	}
}
