package com.senior.desafio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cidades implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ibge_id")
    private Long ibgeId;

    @Column(name ="uf")
    private String uf;

    @Column(name = "name")
    private String name;

    @Column(name = "capital")
    private String capital;

    @Column(name = "lon")
    private String longitude;

    @Column(name = "lat")
    private String latitude;

    @Column(name = "no_accents")
    private String noAccents;

    @Column(name = "alternative_names")
    private String alternativeNames;

    @Column(name = "microregion")
    private String microregion;

    @Column(name = "mesoregion")
    private String mesoregion;
    
    

}
