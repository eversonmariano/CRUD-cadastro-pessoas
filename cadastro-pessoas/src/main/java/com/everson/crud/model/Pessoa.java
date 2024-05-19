package com.everson.crud.model;



import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 150)
    private String nome;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "idade", nullable = false, unique = true, length = 3)
    private int idade;

    @Column(name = "sexo", nullable = false, unique = true, length = 15)
    private String sexo;

    @Column(name = "telefone", nullable = false, unique = true, length = 30)
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, LocalDateTime dataCadastro, int idade, String sexo, String telefone) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.idade = idade;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(dataCadastro, pessoa.dataCadastro) && Objects.equals(sexo, pessoa.sexo) && Objects.equals(telefone, pessoa.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataCadastro, idade, sexo, telefone);
    }
}
