package com.app.apirest.hospital.apirest_hospital.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "SEDE")
@Getter
@Setter
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SEDE",nullable = false)
    private Long idSede;

    @Column(name = "DESC_SEDE")
    private String descSede;

    @Column(name = "FECHA_REGISTRO",nullable = false)
    private Date fechaRegistro;

}
