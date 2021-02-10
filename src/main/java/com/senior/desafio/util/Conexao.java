package com.senior.desafio.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class Conexao {

	public Connection connection;

	/**
	 * Método que devolve conexão
	 *
	 * @return
	 */
	public Connection conectar() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdsenior?useSSL=false", "root",
					"root");
			return con;

		} catch (Exception e) {
			System.out.println("Erro ao conectar. Motivo: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Método que desconecta
	 */
	public void desconectar() {
		try {
			connection.close();
		} catch (Exception e) {
			System.out.println("Erro ao desconectar. Motivo: " + e.getMessage());
		}
	}
}