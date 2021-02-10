package com.senior.desafio.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senior.desafio.entity.Cidades;
import com.senior.desafio.services.CidadesServices;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class CidadesResource {

	@Autowired
	private CidadesServices cidadesServices;

	@ApiOperation(value = "1. Retornar todos os dados paginados do csv")
	@GetMapping(value = "/cidades")
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(this.cidadesServices.listAll(pageable), HttpStatus.OK);
	}

	@ApiOperation(value = "2. Retornar somente as cidades que são capitais ordenadas por nome")
	@GetMapping("/cidades/capital")
	public ResponseEntity<List<Cidades>> listarCidadesCapital() {
		return cidadesServices.listarCidadesCapital();
	}

	@ApiOperation(value = "3. Retornar o nome do estado com a maior e menor quantidade de cidades e a quantidade de cidades")
	@GetMapping("/cidades/estado/quantidade")
	public ResponseEntity<?> listarEstadoQuantidade() {
		return cidadesServices.listarEstadoQuantidade();
	}

	@ApiOperation(value = "4. Retornar a quantidade de cidades por estado")
	@GetMapping("/cidades/count/estado/")
	public List<Object[]> listarQtdCidadesPorEstados() {
		return cidadesServices.listarQtdCidadesPorEstados();
	}

	@ApiOperation(value = "5. Obter os dados da cidade informando o id do IBGE")
	@GetMapping(value = "/cidades/{ibgeId}")
	public ResponseEntity<?> listIbgeId(@PathVariable final Long ibgeId) {
		return new ResponseEntity<>(this.cidadesServices.listIbgeId(ibgeId).get(), HttpStatus.OK);
	}

	@ApiOperation(value = "6. Retornar o nome das cidades baseado em um estado selecionado")
	@GetMapping(value = "/cidades/estado/{uf}")
	public List<Cidades> listCidadesPorUf(@PathVariable(name = "uf") String uf) {
		return cidadesServices.listCidadesPorUf(uf);
	}

	@ApiOperation(value = "7. Permitir adicionar uma nova Cidade")
	@PostMapping("/cidades")
	public ResponseEntity<?> save(@Valid @RequestBody Cidades cidades) {
		return new ResponseEntity<>(this.cidadesServices.create(cidades), HttpStatus.CREATED);
	}

	@ApiOperation(value = "8. Permitir deletar uma cidade")
	@DeleteMapping("cidades/{ibgeId}")
	public ResponseEntity<?> delete(@PathVariable final Long ibgeId) {
		this.cidadesServices.delete(ibgeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "9. Permitir selecionar uma coluna (do CSV) e através dela entrar com uma string para filtrar. retornar assim todos os objetos que contenham tal string")
	@GetMapping(value = "/cidades/find/{column}/{filter}")
	public ResponseEntity<List<Cidades>> findByColumn(@PathVariable("column") String column,
			@PathVariable("filter") String filter) {

		List<Cidades> cities = cidadesServices.findByColumn(column, filter);
		if (cities != null && cities.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(cities);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@ApiOperation(value = "10. Retornar a quantidade de registro baseado em uma coluna. Não deve contar itens iguais ")
	@GetMapping(value = "/cidades/coluna/{column}")
	public ResponseEntity<?> listColuna(@PathVariable("column") String column) {
		return cidadesServices.listColuna(column);
	}

	@ApiOperation(value = "11. Retornar a quantidade de registros total")
	@GetMapping("/cidades/countTotal/")
	public ResponseEntity<?> listarTotalRegistro() {
		return cidadesServices.listarTotalRegistro();
	}

	@ApiOperation(value = "12. Dentre todas as cidades, obter as duas cidades mais distantes uma da outra com base na localização (distância em KM em linha reta)")
	@GetMapping("/cidades/localizacao/")
	public ResponseEntity<List<Cidades>> listarDistanciaLocalizacao() {
		return cidadesServices.listarDistanciaLocalizacao();
	}
}
