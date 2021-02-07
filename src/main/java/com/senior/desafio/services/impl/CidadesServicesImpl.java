package com.senior.desafio.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senior.desafio.entity.Cidades;
import com.senior.desafio.repository.CidadesRepository;
import com.senior.desafio.services.CidadesServices;

@Service
public class CidadesServicesImpl implements CidadesServices {

	private CidadesRepository cidadesRepository;
	
	@Autowired
    public CidadesServicesImpl(CidadesRepository cidadesRepository) {
        this.cidadesRepository = cidadesRepository;
    }

	@Override
	public Optional<Page<Cidades>> listAll(Pageable pageable) {
		return Optional.of(cidadesRepository.findAll(pageable));
	}

}
