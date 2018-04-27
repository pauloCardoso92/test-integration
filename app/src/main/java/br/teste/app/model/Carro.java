package br.teste.app.model;

import java.io.Serializable;

public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nome;

    public Carro(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    

}
