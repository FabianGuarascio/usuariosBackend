package com.insside.fabian.dao;

import com.insside.fabian.model.Contacto;
import com.insside.fabian.model.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class DaoImp implements Dao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Contacto> getContactos() {
        String query= "From Contacto";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Contacto> userGetContactos(long id) {
        String query= "From Contacto WHERE usuario_id= :id";
        return entityManager.createQuery(query).setParameter("id",id).getResultList();
    }


    @Override
    public void borarContacto(long id) {
        Contacto contacto= entityManager.find(Contacto.class,id);
        entityManager.remove(contacto);
    }

    @Override
    public void crearContacto(Contacto contacto) {
        entityManager.merge(contacto);
    }

    @Override
    public void modificarContacto(Contacto contacto) {
        entityManager.merge(contacto);
    }

    @Override
    public Usuario obtenerUsuario(Usuario usuario) {
        String query = "FROM Usuario WHERE nombre= :nombre AND password= :password";
        List<Usuario> lista = entityManager.createQuery(query).setParameter("nombre",usuario.getNombre()).setParameter("password",usuario.getPassword()).getResultList();
        if(lista.isEmpty()){
            return null;
        }
        return lista.get(0);
    }
}
