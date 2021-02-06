package com.senior.desafio.services.csv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.senior.desafio.entity.Cidades;
import com.senior.desafio.repository.CidadesRepository;

@Component
public class LerArquivoCSV {

	@Autowired
    private CidadesRepository cidadesRepository;
	
	public LerArquivoCSV(CidadesRepository cidadesRepository) throws IOException {
        this.cidadesRepository = cidadesRepository;
	}
	
	public boolean lerArquivo() throws IOException {
		
		Reader reader = Files.newBufferedReader(Paths.get("/home/micheldev/Desktop/desafio-senior/cities.csv"));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> cities = csvReader.readAll();
        List<Cidades> cidadesList = new ArrayList<>();
        for (String[] DesafioCidade : cities){
            System.out.println("Ibge_id : " + DesafioCidade[0] +
                    " - Uf : " + DesafioCidade[1] +
                    " - Name : " + DesafioCidade[2]+
                    " - Capital : " + DesafioCidade[3]+
                    " - Lon : " + DesafioCidade[4]+
                    " - Lat : " + DesafioCidade[5]+
                    " - No_accents : " + DesafioCidade[6]+
                    " - Alternative_names : " + DesafioCidade[7]+
                    " - Microregion : " + DesafioCidade[8]+
                    " - mesoregion : " + DesafioCidade[9]
            );

            Cidades cidades =  new Cidades();

            cidades.setIbgeId(Long.valueOf(DesafioCidade[0]));
            cidades.setUf(DesafioCidade[1]);
            cidades.setName(DesafioCidade[2]);
            cidades.setCapital(DesafioCidade[3]);
            cidades.setLongitude(DesafioCidade[4]);
            cidades.setLatitude(DesafioCidade[5]);
            cidades.setNoAccents(DesafioCidade[6]);
            cidades.setAlternativeNames(DesafioCidade[7]);
            cidades.setMicroregion(DesafioCidade[8]);
            cidades.setMesoregion(DesafioCidade[9]);
            cidadesList.add(cidades);
        }
        try{
            cidadesRepository.saveAll(cidadesList);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            return false;
        }
	}
}
