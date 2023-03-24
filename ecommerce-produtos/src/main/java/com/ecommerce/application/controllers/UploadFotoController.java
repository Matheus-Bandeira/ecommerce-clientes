package com.ecommerce.application.controllers;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.application.dtos.ProdutoGetDto;
import com.ecommerce.domain.interfaces.IProdutoDomainService;
import com.ecommerce.domain.models.Produto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Upload Foto")
@RestController
public class UploadFotoController {

	@Autowired
	private IProdutoDomainService produtoDomainService;
	
	
	@ApiOperation("Serviço para upload de foto de produtos.")
	@RequestMapping(value = "/v1/produtos/fotos", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public ResponseEntity<ProdutoGetDto> post(@RequestParam("id") Integer id, @RequestParam("foto") MultipartFile foto) {
		
		String tipo = foto.getContentType();
		
		if(tipo.equals("image/jpeg") || tipo.equals("image/jpg") || tipo.equals("image/png")) {
			
			// capturar o conteudo do arquivo
			byte[] dados = null;
			
			try {
				dados = foto.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Produto produto = produtoDomainService.save(id, dados);
			
			ModelMapper modelMapper = new ModelMapper();
			ProdutoGetDto response = modelMapper.map(produto, ProdutoGetDto.class);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
