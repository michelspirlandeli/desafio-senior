package com.senior.desafio.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.senior.desafio.entity.Cidades;

public interface CidadesServices {

	Optional<Page<Cidades>> listAll(Pageable pageable);
}
