package com.app.apirest.hospital.apirest_hospital.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "CONDICION")
@Getter
@Setter
public class Condicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONDICION",nullable = false)
    private Long idCondicion;

    @Column(name = "DESC_CONDICION")
    private String descCondicion;

    @Column(name = "FECHA_REGISTRO",nullable = false)
    private Date fechaRegistro;
}
