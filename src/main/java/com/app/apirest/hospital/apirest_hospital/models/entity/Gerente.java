package com.app.apirest.hospital.apirest_hospital.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "GERENTE")
@Getter
@Setter
public class Gerente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GERENTE",nullable = false)
    private Long idGerente;

    @Column(name = "DESC_GERENTE")
    private String descGerente;

    @Column(name = "FECHA_REGISTRO",nullable = false)
    private Date fechaRegistro;

}
