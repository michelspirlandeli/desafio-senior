package com.senior.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senior.desafio.entity.Cidades;

@Repository
public interface CidadesRepository extends JpaRepository<Cidades, Long> {

	Cidades findByIbgeId(Long ibgeId);

	public List<Cidades> findByUf(String uf);

	@Query("select uf, COUNT(uf) as total FROM Cidades  GROUP BY uf")
	public List<Object[]> listarQtdCidadesPorEstados();

	public long count();

	Optional<List<Cidades>> findByUfContains(String filter);

	Optional<List<Cidades>> findByNameContains(String filter);

	Optional<List<Cidades>> findByCapitalContains(String filter);

	Optional<List<Cidades>> findByLatitudeContains(Double filter);

	Optional<List<Cidades>> findByLongitudeContains(Double filter);

	Optional<List<Cidades>> findByNoAccentsContains(String filter);

	Optional<List<Cidades>> findByAlternativeNamesContains(String filter);

	Optional<List<Cidades>> findByMicroregionContains(String filter);

	Optional<List<Cidades>> findByMesoregionContains(String filter);

	// count column
	@Query("select uf, COUNT(uf) as total FROM Cidades  GROUP BY uf")
	List<?> countByUf(String column);

	@Query("select name, COUNT(name) as total FROM Cidades  GROUP BY name")
	List<?> countByName(String column);

	@Query("select noAccents, COUNT(noAccents) as total FROM Cidades  GROUP BY noAccents")
	List<?> countByNoAccents(String column);

	@Query("select alternativeNames, COUNT(alternativeNames) as total FROM Cidades  GROUP BY alternativeNames")
	List<?> countByAlternativeNames(String column);

	@Query("select microregion, COUNT(microregion) as total FROM Cidades  GROUP BY microregion")
	List<?> countByMicroregion(String column);

	@Query("select mesoregion, COUNT(mesoregion) as total FROM Cidades  GROUP BY mesoregion")
	List<?> countByMesoregion(String column);


}
