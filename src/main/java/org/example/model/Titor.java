package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "titor")
public class Titor {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long id;
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @Column(name = "apelidos", length = 150, nullable = false)
    String apelidos;

    public Titor() {
    }

    public Titor(Long id, String nome, String apelidos) {
        this.id = id;
        this.nome = nome;
        this.apelidos = apelidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }
}
