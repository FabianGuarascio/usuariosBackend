package com.insside.fabian.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private Long id;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "password")
    @Getter @Setter
    private String password;

}
