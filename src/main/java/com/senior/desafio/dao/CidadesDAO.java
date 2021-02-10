package com.senior.desafio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.senior.desafio.entity.Cidades;
import com.senior.desafio.util.Conexao;

@Component
public class CidadesDAO {

	public List<Cidades> listarCidadesCapital() {
		String sql = "SELECT " + " name, capital " + "FROM " + "bdsenior.cidades " + "WHERE " + " capital = 'true' "
				+ "GROUP BY name " + " ORDER BY name";

		List<Cidades> cidadesModels = new ArrayList<Cidades>();
		PreparedStatement ps = null;
		Conexao conexao = new Conexao();

		try {
			ps = conexao.conectar().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cidades cidadesModel = new Cidades();

				cidadesModel.setName(rs.getString("name"));
				cidadesModel.setCapital(rs.getString("capital"));

				cidadesModels.add(cidadesModel);
			}

		} catch (Exception e) {
			System.out.println("Falha ao listar cidades motivo: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return cidadesModels;
	}

	public List<Cidades> listarDistanciaLocalizacao() {
		String sql = "select * from  bdsenior.cidades where name = (select max(lon) from bdsenior.cidades) "
				+ "select * from  bdsenior.cidades where name = (select min(lat) from bdsenior.cidades) ";

		List<com.senior.desafio.entity.Cidades> cidadesModels = new ArrayList<Cidades>();
		PreparedStatement ps = null;
		Conexao conexao = new Conexao();

		try {
			ps = conexao.conectar().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				com.senior.desafio.entity.Cidades cidadesModel = new com.senior.desafio.entity.Cidades();

				cidadesModel.setLongitude(rs.getString("lon"));
				cidadesModel.setLatitude(rs.getString("lat"));
				cidadesModels.add(cidadesModel);
			}

		} catch (Exception e) {
			System.out.println("Falha ao listar cidades motivo: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return cidadesModels;
	}

	public List<Cidades> listState() {
		String sql = "(SELECT c.uf, count(*) from bdsenior.cidades c\n" + "group by c.uf\n" + "order by count(*) ASC\n"
				+ "LIMIT  1)\n" + "UNION ALL\n" + "(SELECT c.uf, count(*) from bdsenior.cidades c\n" + "group by c.uf\n"
				+ "order by count(*) DESC \n" + "LIMIT  1)";

		List<Cidades> cidadesModels = new ArrayList<Cidades>();
		PreparedStatement ps = null;
		Conexao conexao = new Conexao();

		try {
			ps = conexao.conectar().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cidades cidadesModel = new Cidades();

				cidadesModel.setUf(rs.getString("uf"));

				cidadesModels.add(cidadesModel);
			}

		} catch (Exception e) {
			System.out.println("Falha ao listar cidades motivo: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return cidadesModels;
	}

}
