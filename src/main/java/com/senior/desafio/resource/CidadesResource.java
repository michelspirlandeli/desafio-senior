package com.senior.desafio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senior.desafio.services.CidadesServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/api")
@RequiredArgsConstructor
public class CidadesResource {
	
	@Autowired
	private CidadesServices cidadesServices;

	@GetMapping(value = "/cidades")
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(this.cidadesServices.listAll(pageable), HttpStatus.OK);
	}
}
