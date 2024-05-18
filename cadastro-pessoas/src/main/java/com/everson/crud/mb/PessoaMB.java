package com.everson.crud.mb;

import com.everson.crud.ejb.PessoaBean;
import com.everson.crud.model.Pessoa;

import jakarta.annotation.PostConstruct;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PessoaMB implements Serializable {

    private Pessoa pessoa;
    private List<Pessoa> pessoas;

    @Inject
    private PessoaBean pessoaBean;

    @PostConstruct
    public void init() {
        pessoa = new Pessoa();
        pessoas = pessoaBean.findAll();
    }

    public void save() {
        if (pessoa.getId() == null) {
            pessoaBean.save(pessoa);
        } else {
            pessoaBean.update(pessoa);
        }
        pessoa = new Pessoa();
        pessoas = pessoaBean.findAll();
    }

    public void edit(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void delete(Long id) {
        pessoaBean.delete(id);
        pessoas = pessoaBean.findAll();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
