package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "titor")
public class Titor {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @Column(name = "id_titor")
    private Long id;
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @Column(name = "apelidos", length = 150, nullable = false)
    String apelidos;

    @OneToMany(mappedBy = "titor", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Alumno> alumnos;

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
