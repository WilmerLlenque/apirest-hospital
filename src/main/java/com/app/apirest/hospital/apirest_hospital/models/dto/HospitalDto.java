package com.app.apirest.hospital.apirest_hospital.models.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HOSPITAL")
@Getter
@Setter
@NoArgsConstructor
@NamedStoredProcedureQuery(name = "hospital.procedimientoHospital"
        ,procedureName = "SP_HOSPITAL_ID_F"
        ,parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "p_id_hospital",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "p_id_distrito",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "p_nombre",type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "p_antiguedad",type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "p_area",type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "p_id_sede",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "p_id_gerente",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "p_id_condicion",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "P_fecha_registro",type = Date.class)
        })
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOSPITAL",nullable = false)
    private Long idHospital;

    @Column(name = "ID_DISTRITO",nullable = false)
    private Long idDistrito;

    @Column(name = "NOMBRE",nullable = false,length = 500)
    private String nombre;

    @Column(name = "ANTIGUEDAD",nullable = false)
    private Integer antiguedad;

    @Column(name = "AREA",nullable = false)
    private Integer area;

    @Column(name = "ID_SEDE",nullable = false)
    private Long idSede;

    @Column(name = "ID_GERENTE",nullable = false)
    private Long idGerente;

    @Column(name = "ID_CONDICION",nullable = false)
    private Long idCondicion;

    @Column(name = "FECHA_REGISTRO",nullable = false)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "ID_DISTRITO",referencedColumnName = "ID_DISTRITO",insertable = false,updatable = false)
    private Distrito distrito;

    @OneToMany
    @JoinColumn(name = "ID_SEDE",referencedColumnName = "ID_SEDE",insertable = false,updatable = false)
    private List<Sede> sede;

    @OneToOne
    @JoinColumn(name = "ID_GERENTE",referencedColumnName = "ID_GERENTE",insertable = false,updatable = false)
    private Gerente gerente;

    @OneToMany
    @JoinColumn(name = "ID_CONDICION",referencedColumnName = "ID_CONDICION",insertable = false,updatable = false)
    private List<Condicion> condicion;

}
