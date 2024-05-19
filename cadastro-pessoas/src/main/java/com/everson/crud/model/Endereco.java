package com.everson.crud.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String estado;
    private String cidade;
    private String logradouro;
    private int numero;
    private int cep;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Endereco() {
    }

    public Endereco(Long id, String estado, String cidade, String logradouro, int numero, int cep, Pessoa pessoa) {
        this.id = id;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro() {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return numero == endereco.numero && cep == endereco.cep && Objects.equals(id, endereco.id) && Objects.equals(estado, endereco.estado) && Objects.equals(cidade, endereco.cidade) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(pessoa, endereco.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estado, cidade, logradouro, numero, cep, pessoa);
    }
}
