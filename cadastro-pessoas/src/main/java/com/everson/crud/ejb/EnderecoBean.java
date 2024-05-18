package com.everson.crud.ejb;

import com.everson.crud.dao.EnderecoDAO;
import com.everson.crud.model.Endereco;

import javax.ejb.Stateless;

import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class EnderecoBean {

    @Inject
    private EnderecoDAO enderecoDAO;

    public void save(Endereco endereco) {
        enderecoDAO.save(endereco);
    }

    public void update(Endereco endereco) {
        enderecoDAO.update(endereco);
    }

    public void delete(Long id) {
        enderecoDAO.delete(id);
    }

    public Endereco findById(Long id) {
        return enderecoDAO.findById(id);
    }

    public List<Endereco> findAll() {
        return enderecoDAO.findAll();
    }
}

