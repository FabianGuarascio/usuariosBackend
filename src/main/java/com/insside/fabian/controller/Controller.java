package com.insside.fabian.controller;

import com.insside.fabian.dao.Dao;
import com.insside.fabian.model.Contacto;
import com.insside.fabian.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.insside.fabian.util.JWTUtil;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Dao dao;

    @Autowired
    private JWTUtil jwtUtil;

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @CrossOrigin
    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogueado= dao.obtenerUsuario(usuario);
        if(usuarioLogueado != null){
            String tokenJwt= jwtUtil.create(String.valueOf(usuarioLogueado.getId()),usuarioLogueado.getNombre());
            return tokenJwt;
        }
        return "FAIL";
    }
    @CrossOrigin
    @RequestMapping(value = "api/login/usuario",method = RequestMethod.POST)
    public String loginUsuarioId(@RequestBody Usuario usuario){
        Usuario usuarioLogueado= dao.obtenerUsuario(usuario);
        if(usuarioLogueado != null){
            return String.valueOf(usuarioLogueado.getId());
        }
        return "FAIL2";
    }

    

    @CrossOrigin
    @RequestMapping(value = "api/usuario/{id}")
    public List<Contacto> userOtenerContactos(@PathVariable long id,@RequestHeader(value = "Authorization")String token){
        if (!validarToken(token)) { return null; }
        return dao.userGetContactos(id);
    }

    @CrossOrigin
    @RequestMapping(value = "api/usuario/crear", method = RequestMethod.POST)
    public void crearContacto(@RequestBody Contacto contacto,@RequestHeader(value = "Authorization")String token){
        if (!validarToken(token)) { return; }
        dao.crearContacto(contacto);
    }

    @CrossOrigin
    @RequestMapping(value = "api/usuario/modificar", method = RequestMethod.PUT)
    public void modificarContacto(@RequestBody Contacto contacto,@RequestHeader(value = "Authorization")String token){
        if (!validarToken(token)) { return; }
        dao.modificarContacto(contacto);
    }



    @CrossOrigin
    @RequestMapping(value = "api/usuario/borrar/{id}",method = RequestMethod.DELETE)
    public void borrarContacto(@PathVariable long id,@RequestHeader(value = "Authorization")String token){
        if (!validarToken(token)) { return; }
        dao.borarContacto(id);
    }

}
