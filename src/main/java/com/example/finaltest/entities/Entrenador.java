package com.example.finaltest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
public class Entrenador implements Serializable {
    @Id
    @SequenceGenerator(name="entrenador_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="entrenador_id_seq")
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer tipoPokemon;
    private Date fechaDescrubrimiento;
    private Integer generacion;
    private String uuid;
    private String email;
}