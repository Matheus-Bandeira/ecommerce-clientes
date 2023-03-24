package com.ecommerce.application.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.application.dtos.CategoriaGetDto;
import com.ecommerce.domain.interfaces.ICategoriaDomainService;
import com.ecommerce.domain.models.Categoria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Categorias")
@RestController
public class CategoriasController {

	@Autowired
	private ICategoriaDomainService categoriaDomainService;

	
	@ApiOperation("Serviço para consulta de categorias")
	@GetMapping("/v1/categorias")
	public ResponseEntity<List<CategoriaGetDto>> getAll() {

		ModelMapper modelMapper = new ModelMapper();

		List<Categoria> categorias = categoriaDomainService.findAll();
		List<CategoriaGetDto> dto = modelMapper.map(categorias, new TypeToken<List<CategoriaGetDto>>() {
		}.getType());

		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
}
