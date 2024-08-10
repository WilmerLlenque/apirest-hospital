package com.app.apirest.hospital.apirest_hospital.models.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "HOSPITAL")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOSPITAL",nullable = false)
    private Long id_hospital;

    @Column(name = "ID_DISTRITO",nullable = false)
    private Long id_distrito;

    @Column(name = "NOMBRE",nullable = false,length = 500)
    private String nombre;

    @Column(name = "ANTIGUEDAD",nullable = false)
    private Integer antiguedad;

    @Column(name = "AREA",nullable = false)
    private Integer area;

    @Column(name = "ID_SEDE",nullable = false)
    private Long id_sede;

    @Column(name = "ID_GERENTE",nullable = false)
    private Long id_gerente;

    @Column(name = "ID_CONDICION",nullable = false)
    private Long id_condicion;

    @Column(name = "FECHA_REGISTRO",nullable = false)
    private Date fecha_registro;
}
