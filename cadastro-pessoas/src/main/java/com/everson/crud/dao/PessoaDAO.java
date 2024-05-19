package com.everson.crud.dao;

import com.everson.crud.model.Pessoa;

import javax.persistence.*;

import javax.ejb.Stateless;

import java.util.List;

@Stateless
public class PessoaDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Pessoa pessoa) {
        em.persist(pessoa);
    }

    public void update(Pessoa pessoa) {
        em.merge(pessoa);
    }

    public void delete(Long id) {
        Pessoa pessoa = em.find(Pessoa.class, id);
        if (pessoa != null) {
            em.remove(pessoa);
        }
    }

    public Pessoa findById(Long id) {
        return em.find(Pessoa.class, id);
    }

    public List<Pessoa> findAll() {
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }
}
