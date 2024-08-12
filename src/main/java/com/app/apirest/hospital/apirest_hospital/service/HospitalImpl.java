package com.app.apirest.hospital.apirest_hospital.service;

import com.app.apirest.hospital.apirest_hospital.models.dao.HospitalDao;
import com.app.apirest.hospital.apirest_hospital.models.dto.HospitalDto;
import com.app.apirest.hospital.apirest_hospital.models.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class HospitalImpl implements  IHospitalService{

    @Autowired
    private HospitalDao hospitalDao;

    @Override
    public List<Hospital> findAll() {
        return hospitalDao.findAll();
    }

    @Override
    @Transactional
    public Hospital save(HospitalDto hospitalDto) {
        Hospital hospital=Hospital.builder()
                .idHospital(hospitalDto.getIdHospital())
                .idDistrito(hospitalDto.getIdDistrito())
                .nombre(hospitalDto.getNombre())
                .antiguedad(hospitalDto.getAntiguedad())
                .area(hospitalDto.getArea())
                .idSede(hospitalDto.getIdSede())
                .idGerente(hospitalDto.getIdGerente())
                .idCondicion(hospitalDto.getIdCondicion())
                .fechaRegistro(hospitalDto.getFechaRegistro())
                .build();

        return hospitalDao.save(hospital);
    }

    @Override
    @Transactional(readOnly = true)
    public Hospital getById(Long id) {
        return hospitalDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Hospital hospital) {
        hospitalDao.delete(hospital);
    }

    @Override
    public boolean existById(Long id) {
        return hospitalDao.existsById(id);
    }

    @Override
    public Map<String, Object> getHospitalId(Long p_id_hospital) {
        return hospitalDao.getHospitalId(p_id_hospital);
    }

    @Override
    public void deleteHospitalId(Long idHospital) {
        hospitalDao.deleteHospitalId(idHospital);
    }

    @Override
    public void updateHospital(Long idHospital, Long idDistrito, String nombre, Integer antiguedad, Integer area,
                               Long idSede, Long idGerente, Long idCondicion, Date fechaRegistro) {
        hospitalDao.updateHospital(idHospital,idDistrito,nombre,antiguedad,area,idSede,idGerente,idCondicion,
                               fechaRegistro);
    }

    @Override
    public void registrarHospital(Long idDistrito, String nombre, Integer antiguedad, Integer area, Long idSede,
                                  Long idGerente, Long idCondicion) {
        hospitalDao.registrarHospital(idDistrito,nombre,antiguedad,area,idSede,idGerente,idCondicion);
    }

}
