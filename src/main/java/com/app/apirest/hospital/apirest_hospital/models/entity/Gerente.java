package com.app.apirest.hospital.apirest_hospital.models.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "GERENTE")
public class Gerente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GERENTE",nullable = false)
    private Long id_hospital;

    @Column(name = "DESC_GERENTE",nullable = false,length = 500)
    private String desc_gerente;

}
