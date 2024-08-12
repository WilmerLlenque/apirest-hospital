package com.app.apirest.hospital.apirest_hospital.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "PROVINCIA")
@Getter
@Setter
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROVINCIA",nullable = false)
    private Long idProvincia;

    @Column(name = "DESC_PROVINCIA",nullable = false,length = 500)
    private String descProvincia;

    @Column(name = "FECHA_REGISTRO",nullable = false)
    private Date fechaRegistro;
}
