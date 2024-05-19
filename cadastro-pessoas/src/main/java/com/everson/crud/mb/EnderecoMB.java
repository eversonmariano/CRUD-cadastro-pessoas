package com.everson.crud.mb;



import com.everson.crud.ejb.EnderecoBean;
import com.everson.crud.model.Endereco;


import javax.annotation.PostConstruct;


import javax.faces.view.ViewScoped;

import java.io.Serializable;
import java.util.List;

@ViewScoped
public class EnderecoMB implements Serializable {

    private Endereco endereco;
    private List<Endereco> enderecos;


    private EnderecoBean enderecoBean;

    @PostConstruct
    public void init() {
        endereco = new Endereco();
        enderecos = enderecoBean.findAll();
    }

    public void save() {
        if (endereco.getId() == null) {
            enderecoBean.save(endereco);
        } else {
            enderecoBean.update(endereco);
        }
        endereco = new Endereco();
        enderecos = enderecoBean.findAll();
    }

    public void edit(Endereco endereco) {
        this.endereco = endereco;
    }

    public void delete(Long id) {
        enderecoBean.delete(id);
        enderecos = enderecoBean.findAll();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
