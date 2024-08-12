package com.app.apirest.hospital.apirest_hospital.models.dto;


import com.app.apirest.hospital.apirest_hospital.models.entity.Condicion;
import com.app.apirest.hospital.apirest_hospital.models.entity.Distrito;
import com.app.apirest.hospital.apirest_hospital.models.entity.Gerente;
import com.app.apirest.hospital.apirest_hospital.models.entity.Sede;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class HospitalDto {

    private Long idHospital;
    private Long idDistrito;
    private String nombre;
    private Integer antiguedad;
    private Integer area;
    private Long idSede;
    private Long idGerente;
    private Long idCondicion;
    private Date fechaRegistro;

}
