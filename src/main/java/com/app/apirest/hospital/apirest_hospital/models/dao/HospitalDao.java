package com.app.apirest.hospital.apirest_hospital.models.dao;

import com.app.apirest.hospital.apirest_hospital.models.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;


public interface HospitalDao extends JpaRepository<Hospital, Long> {

    @Procedure(name = "hospital.procedimientoHospital")
    Map<String, Object> getHospitalId(@Param("idHosp") Long idHosp);

    @Procedure(name = "hospital.eliminarHospital")
    void deleteHospitalId(@Param("idHospital") Long idHospital);

    @Procedure(name = "hospital.updateHospital")
    void updateHospital(
            @Param("idHospital") Long idHospital,
            @Param("idDistrito") Long idDistrito,
            @Param("nombre") String nombre,
            @Param("antiguedad") Integer antiguedad,
            @Param("area") Integer area,
            @Param("idSede") Long idSede,
            @Param("idGerente") Long idGerente,
            @Param("idCondicion") Long idCondicion,
            @Param("fechaRegistro") Date fechaRegistro
    );

    @Procedure(name = "hospital.registrarHospital")
    void registrarHospital(
            @Param("idDistrito") Long idDistrito,
            @Param("nombre") String nombre,
            @Param("antiguedad") Integer antiguedad,
            @Param("area") Integer area,
            @Param("idSede") Long idSede,
            @Param("idGerente") Long idGerente,
            @Param("idCondicion") Long idCondicion
    );

    @Modifying
    @Query(value = "{call SP_HOSPITAL_REGISTRAR(:idHospital, :idDistrito, :nombre, :antiguedad" +
                   ", :area, :idSede, :idGerente, :idCondicion, :fechaRegistro)}",nativeQuery = true)
    @Transactional
    void addHospital(Long idHospital, Long idDistrito, String nombre, Integer antiguedad,
                            Integer area, Long idSede, Long idGerente, Long idCondicion, Date fechaRegistro);

}
