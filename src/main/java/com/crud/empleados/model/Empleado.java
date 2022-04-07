package com.crud.empleados.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @Column(name="nombre",length=60, nullable=false)
    private String nombre;

    @Getter @Setter
    @Column(name="apellidos", length=60,nullable=false)
    private String apellidos;

    @Getter @Setter
    @Column(name="email",length=60, nullable=false)
    private String email;

    public Empleado() {
    }

    //Constructor
    public Empleado(Long id, String nombre, String apellidos, String email){
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    //Getters And Setters
/*
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
*/

}
