package com.example.finaltest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Pokemon implements Serializable {
    @Id
    @Column(nullable = false)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer tipoPokemon;
    private Date fechaDescrubrimiento;
    private Integer generacion;
    private String uuid;
}