package com.app.apirest.hospital.apirest_hospital.controller;

import com.app.apirest.hospital.apirest_hospital.models.dto.HospitalDto;
import com.app.apirest.hospital.apirest_hospital.models.entity.Hospital;
import com.app.apirest.hospital.apirest_hospital.models.payload.MensajeResponse;
import com.app.apirest.hospital.apirest_hospital.service.HospitalImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hospital")
@CrossOrigin({"http://localhost:4200"})
public class HospitalController {

    @Autowired
    private HospitalImpl service;

    @GetMapping("/all")
    public List<Hospital> getAll() {
        return service.findAll();
    }

    @GetMapping("/procedimiento/{idHospital}")
    public Map<String, Object> getHospitalId(@PathVariable Long idHospital){
        return service.getHospitalId(idHospital);
    }

    @GetMapping("/hospital/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id){
        Hospital hospital= service.getById(id);
        if (hospital==null){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El registro que intenta buscar, no existe")
                            .object(null)
                            .build()
                    ,HttpStatus.NOT_FOUND);
        }
        HospitalDto hospitalDto= HospitalDto.builder()
                .idHospital(hospital.getIdHospital())
                .idDistrito(hospital.getIdDistrito())
                .nombre(hospital.getNombre())
                .antiguedad(hospital.getAntiguedad())
                .area(hospital.getArea())
                .idSede(hospital.getIdSede())
                .idGerente(hospital.getIdGerente())
                .idCondicion(hospital.getIdCondicion())
                .fechaRegistro(hospital.getFechaRegistro())
                .build();

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(hospitalDto)
                        .build()
                ,HttpStatus.OK);
    }

    @PostMapping("/saveProce")
    public ResponseEntity<?> save1(@RequestBody HospitalDto hospitalDto){
        try {
            service.registrarHospital(
                    hospitalDto.getIdDistrito(), hospitalDto.getNombre(), hospitalDto.getAntiguedad(),
                    hospitalDto.getArea(), hospitalDto.getIdSede(), hospitalDto.getIdGerente(),
                    hospitalDto.getIdCondicion()
            );
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado Correctamente")
                    .object(null)
                    .build(), HttpStatus.CREATED);
        }catch (DataAccessException dae){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(dae.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    @PutMapping("/updateProce/{id}")
    public ResponseEntity<?> update2(@RequestBody HospitalDto hospitalDto,@PathVariable Long id){

        try {
            if (service.existById(id)){
                service.updateHospital(
                        id,
                        hospitalDto.getIdDistrito(), hospitalDto.getNombre(), hospitalDto.getAntiguedad(),
                        hospitalDto.getArea(), hospitalDto.getIdSede(), hospitalDto.getIdGerente(),
                        hospitalDto.getIdCondicion(), hospitalDto.getFechaRegistro()
                );
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Actualizado Correctamente")
                        .object(null)
                        .build(),HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                .object(null)
                                .build()
                        ,HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException dae){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(dae.getMessage())
                            .object(null)
                            .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("/deleteProce/{idHospital}")
    public ResponseEntity<?> deleteHospitalId(@PathVariable Long idHospital){
        try {
            if (service.existById(idHospital)){
                service.deleteHospitalId(idHospital);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Eliminado correctamente")
                        .object(null)
                        .build(),HttpStatus.OK);
            }else {
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("El id no se encuentra en la base de datos")
                        .object(null)
                        .build(),HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException dae){
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(dae.getMessage())
                            .object(null)
                            .build()
                    ,HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}
