package com.app.apirest.hospital.apirest_hospital.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HOSPITAL")
@NamedStoredProcedureQuery(name = "hospital.procedimientoHospital"
        ,procedureName = "SP_HOSPITAL_ID_F"
        ,parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idHosp",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "idHospital",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "idDistrito",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "nombre",type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "antiguedad",type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "area",type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "idSede",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "idGerente",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "idCondicion",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "fechaRegistro",type = Date.class)
})
@NamedStoredProcedureQuery(name = "hospital.updateHospital"
        ,procedureName = "SP_HOSPITAL_ACTUALIZAR"
        ,parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idHospital",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idDistrito",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "nombre",type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "antiguedad",type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "area",type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idSede",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idGerente",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idCondicion",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "fechaRegistro",type = Date.class)
})
@NamedStoredProcedureQuery(name = "hospital.registrarHospital"
        ,procedureName = "SP_HOSPITAL_REGISTRAR"
        ,parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idDistrito",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "nombre",type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "antiguedad",type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "area",type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idSede",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idGerente",type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idCondicion",type = Long.class)
})
@NamedStoredProcedureQuery(name = "hospital.eliminarHospital"
        ,procedureName = "SP_HOSPITAL_ELIMINAR"
        ,parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "idHospital",type = Long.class),
})
/*
@NamedNativeQueries({
        @NamedNativeQuery(name = "Hospital_registrarHospital",
                query = "call SP_HOSPITAL_REGISTRAR(:employeeNumber, :newDesignation, :)",
                resultClass = Hospital.class)
})
*/
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
