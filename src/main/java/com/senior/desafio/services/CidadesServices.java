package com.senior.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.senior.desafio.entity.Cidades;

public interface CidadesServices {

	Optional<Page<Cidades>> listAll(Pageable pageable);

	ResponseEntity<List<Cidades>> listarCidadesCapital();

	ResponseEntity<?> listarEstadoQuantidade();

	List<Object[]> listarQtdCidadesPorEstados();

	Optional<Cidades> listIbgeId(Long ibgeId);

	List<Cidades> listCidadesPorUf(String uf);

	Optional<Cidades> create(Cidades cidades);

	void delete(Long id);

	List<Cidades> findByColumn(String column, String filter);

	ResponseEntity<?> listColuna(String column);

	ResponseEntity<?> listarTotalRegistro();

	ResponseEntity<List<Cidades>> listarDistanciaLocalizacao();

}
