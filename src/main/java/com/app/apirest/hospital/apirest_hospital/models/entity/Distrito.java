package com.app.apirest.hospital.apirest_hospital.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "DISTRITO")
@Getter
@Setter
public class Distrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISTRITO",nullable = false)
    private Long idDistrito;

    @Column(name = "ID_PROVINCIA",nullable = false)
    private Long idProvincia;

    @Column(name = "DESC_DISTRITO",nullable = false,length = 500)
    private String descDistrito;

    @Column(name = "FECHA_REGISTRO",nullable = false)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "ID_PROVINCIA",referencedColumnName = "ID_PROVINCIA",insertable = false,updatable = false)
    private Provincia provincia;
}
