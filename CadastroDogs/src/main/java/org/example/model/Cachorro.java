package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cachorro {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome_cachorro;
    private Integer idade;
    private String nome_dono;
    private String sexo_cachorro;

    @ManyToOne
    private TypeCachorro typeCachorro;


    public Cachorro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNomeCachorro() {
        return nome_cachorro;
    }

    public void setNomeCachorro(String nome_cachorro) {
        this.nome_cachorro = nome_cachorro;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }


    public String getNomeDono() {
        return nome_dono;
    }

    public void setNomeDono(String nome_dono) {
        this.nome_dono = nome_dono;
    }


    public String getSexoCachorro() {
        return sexo_cachorro;
    }

    public void setSexoCachorro(String sexo_cachorro) {
        this.sexo_cachorro = sexo_cachorro;
    }

    public TypeCachorro getTypeCachorro() {
        return typeCachorro;
    }

    public void setTypeCachorro(TypeCachorro typeCachorro) {
        this.typeCachorro = typeCachorro;
    }
}