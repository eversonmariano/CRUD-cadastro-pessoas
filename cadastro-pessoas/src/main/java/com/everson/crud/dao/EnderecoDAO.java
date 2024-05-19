package com.everson.crud.dao;

import com.everson.crud.model.Endereco;
import javax.ejb.Stateless;
import javax.persistence.*;

import java.util.List;

@Stateless
public class EnderecoDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Endereco endereco) {
        em.persist(endereco);
    }

    public void update(Endereco endereco) {
        em.merge(endereco);
    }

    public void delete(Long id) {
        Endereco endereco = em.find(Endereco.class, id);
        if (endereco != null) {
            em.remove(endereco);
        }
    }

    public Endereco findById(Long id) {
        return em.find(Endereco.class, id);
    }

    public List<Endereco> findAll() {
        return em.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
    }
}

