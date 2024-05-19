package com.everson.crud.ejb;



import com.everson.crud.dao.PessoaDAO;
import com.everson.crud.model.Pessoa;

import javax.ejb.Stateless;



import java.util.List;

@Stateless
public class PessoaBean {


    private PessoaDAO pessoaDAO;

    public void save(Pessoa pessoa) {
        pessoaDAO.save(pessoa);
    }

    public void update(Pessoa pessoa) {
        pessoaDAO.update(pessoa);
    }

    public void delete(Long id) {
        pessoaDAO.delete(id);
    }

    public Pessoa findById(Long id) {
        return pessoaDAO.findById(id);
    }

    public List<Pessoa> findAll() {
        return pessoaDAO.findAll();
    }
}
