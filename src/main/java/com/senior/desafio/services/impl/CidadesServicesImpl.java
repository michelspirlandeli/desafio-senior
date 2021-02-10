package com.senior.desafio.services.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.senior.desafio.dao.CidadesDAO;
import com.senior.desafio.entity.Cidades;
import com.senior.desafio.exceptions.ResourceNotFoundException;
import com.senior.desafio.repository.CidadesRepository;
import com.senior.desafio.services.CidadesServices;

import lombok.NonNull;

@Service
public class CidadesServicesImpl implements CidadesServices {

	private CidadesRepository cidadesRepository;
	private CidadesDAO cidadesDAO;

	@Autowired
	public CidadesServicesImpl(CidadesRepository cidadesRepository, CidadesDAO cidadesDAO) {
		this.cidadesRepository = cidadesRepository;
		this.cidadesDAO = cidadesDAO;
	}

	@Override
	public Optional<Page<Cidades>> listAll(Pageable pageable) {
		return Optional.of(cidadesRepository.findAll(pageable));
	}

	@Override
	public ResponseEntity<List<Cidades>> listarCidadesCapital() {
		List<Cidades> cidadesModels = new ArrayList<Cidades>();

		cidadesModels = cidadesDAO.listarCidadesCapital();

		if (cidadesModels.size() == 0) {
			System.out.println("Nenhuma cidades foi encontrada.");
		}

		return ResponseEntity.status(HttpStatus.OK).body(cidadesModels);
	}

	@Override
	public ResponseEntity<?> listarEstadoQuantidade() {

		List<Cidades> cidadesModels = new ArrayList<Cidades>();

		cidadesModels = cidadesDAO.listState();
		if (cidadesModels.isEmpty()) {
			return new ResponseEntity<>(cidadesModels, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cidadesModels, HttpStatus.OK);
	}

	@Override
	public List<Object[]> listarQtdCidadesPorEstados() {
		return this.cidadesRepository.listarQtdCidadesPorEstados();
	}

	@Override
	public Optional<Cidades> listIbgeId(@NonNull final Long ibgeId) {
		return Optional.of(this.cidadesRepository.findByIbgeId(ibgeId));
	}

	@Override
	public List<Cidades> listCidadesPorUf(String uf) {
		return this.cidadesRepository.findByUf(uf);
	}
	
	@Override
	public Optional<Cidades> create(Cidades cidadesModel) {

		this.cidadesRepository.save(cidadesModel);
		return Optional.of(cidadesModel);
	}

	@Override
	public void delete(@NonNull final Long id) {
		try {
			this.cidadesRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not found " + id);
		}
	}

	@Override
	public List<Cidades> findByColumn(String column, String filter) {

		Optional<List<Cidades>> filterCities = null;

		switch (column) {

		case "ibgeId":
			Optional<Cidades> id = cidadesRepository.findById(Long.parseLong(filter));
			if (id.isPresent()) {
				List<Cidades> listCities = new ArrayList<Cidades>();
				listCities.add(id.get());
				return listCities;
			}
			break;
		case "uf":
			filterCities = cidadesRepository.findByUfContains(filter);
			break;
		case "name":
			filterCities = cidadesRepository.findByNameContains(filter);
			break;
		case "capital":
			filterCities = cidadesRepository.findByCapitalContains(filter);
			break;
		case "longitude":
			filterCities = cidadesRepository.findByLongitudeContains(Double.parseDouble(filter));
			break;
		case "latitude":
			filterCities = cidadesRepository.findByLatitudeContains(Double.parseDouble(filter));
			break;
		case "noAccents":
			filterCities = cidadesRepository.findByNoAccentsContains(filter);
			break;
		case "alternativeNames":
			filterCities = cidadesRepository.findByAlternativeNamesContains(filter);
			break;
		case "microregion":
			filterCities = cidadesRepository.findByMicroregionContains(filter);
			break;
		case "mesoregion":
			filterCities = cidadesRepository.findByMesoregionContains(filter);
			break;

		default:
			break;
		}

		if (filterCities != null && filterCities.isPresent()) {
			return filterCities.get();
		}

		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> listColuna(String column) {
		Map<Object, Object> response = new LinkedHashMap();

		Integer total = 0;
		switch (column) {
		case "uf":
			total = cidadesRepository.countByUf(column).size();
			break;
		case "name":
			total = cidadesRepository.countByName(column).size();
			break;
		case "noAccents":
			total = cidadesRepository.countByNoAccents(column).size();
			break;
		case "alternativeNames":
			total = cidadesRepository.countByAlternativeNames(column).size();
			break;
		case "microregion":
			total = cidadesRepository.countByMicroregion(column).size();
			break;
		case "mesoregion":
			total = cidadesRepository.countByMesoregion(column).size();
			break;
		default:
			break;
		}

		response.put("column", column);
		response.put("total", total);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResponseEntity<?> listarTotalRegistro() {
		Long total = this.cidadesRepository.count();
		Map<Object, Object> response = new LinkedHashMap();
		response.put("total de registro", total);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Cidades>> listarDistanciaLocalizacao() {

		List<Cidades> cidadesModels = new ArrayList<Cidades>();

		cidadesModels = cidadesDAO.listarDistanciaLocalizacao();

		return ResponseEntity.status(HttpStatus.OK).body(cidadesModels);
	}

}
