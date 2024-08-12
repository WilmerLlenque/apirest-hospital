package com.app.apirest.hospital.apirest_hospital.service;

import com.app.apirest.hospital.apirest_hospital.models.dto.HospitalDto;
import com.app.apirest.hospital.apirest_hospital.models.entity.Hospital;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IHospitalService {

    List<Hospital> findAll();

    Hospital save(HospitalDto cliente);

    Hospital getById(Long id);

    void delete(Hospital cliente);

    boolean existById(Long id);

    Map<String, Object> getHospitalId(Long p_id_hospital);

    void deleteHospitalId(Long idHospital);

    void updateHospital(Long idHospital, Long idDistrito, String nombre, Integer antiguedad,
                        Integer area,Long idSede,Long idGerente, Long idCondicion, Date fechaRegistro);

    void registrarHospital(Long idDistrito, String nombre, Integer antiguedad, Integer area,
                               Long idSede, Long idGerente, Long idCondicion);

}
