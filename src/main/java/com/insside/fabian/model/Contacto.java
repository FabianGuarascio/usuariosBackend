package com.insside.fabian.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter @Setter
    @Column(name = "apellido")
    private String apellido;

    @Getter @Setter
    @Column(name = "telefono")
    private int telefono;

    @Getter @Setter
    @Column(name = "email")
    private String email;

    @Getter @Setter
    @Column(name = "pais")
    private String pais;

    @Getter @Setter
    @Column(name = "ciudad")
    private String ciudad;

    @Getter @Setter
    @Column(name = "calle")
    private String calle;

    @Getter @Setter
    @Column(name = "usuario_id")
    private Long usuario_id;



}
