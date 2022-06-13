package com.insside.fabian.dao;

import com.insside.fabian.model.Contacto;
import com.insside.fabian.model.Usuario;

import java.util.List;

public interface Dao {

    List<Contacto> getContactos();
    List<Contacto> userGetContactos(long id);
    void borarContacto(long id);
    void crearContacto(Contacto contacto);
    void modificarContacto(Contacto contacto);
    Usuario obtenerUsuario(Usuario usuario);
}
