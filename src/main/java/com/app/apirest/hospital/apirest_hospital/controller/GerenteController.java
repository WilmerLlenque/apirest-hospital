package com.app.apirest.hospital.apirest_hospital.controller;

import com.app.apirest.hospital.apirest_hospital.models.entity.Gerente;
import com.app.apirest.hospital.apirest_hospital.service.GerenteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GerenteController {

    @Autowired
    private GerenteImpl gerente;

    @GetMapping("/{id}")
    public Gerente getById(@PathVariable Long id) {
        return gerente.findById(id);
    }

    @GetMapping("/all")
    public List<Gerente> getAll() {
        return gerente.findAll();
    }
}
