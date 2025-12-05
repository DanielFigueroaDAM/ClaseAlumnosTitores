package org.example.model;

import jakarta.persistence.*;


/*

CREATE TABLE alumno (
id_alumno SERIAL PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
apelidos VARCHAR(150) NOT NULL,
id_titor INTEGER NOT NULL,
CONSTRAINT fk_titor
FOREIGN KEY (id_titor)
REFERENCES titor (id_titor)
ON UPDATE CASCADE
ON DELETE RESTRICT
);
 */

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_alumno")
    private Long id;
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @Column(name = "apelidos", length = 150, nullable = false)
    private String apelidos;
    @ManyToOne
    @JoinColumn(name = "id_titor", nullable = false)
    private Titor titor;
    public Alumno() {
    }
    public Alumno(Long id, String nome, String apelidos, Titor titor) {
        this.id = id;
        this.nome = nome;
        this.apelidos = apelidos;
        this.titor = titor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public Titor getTitor() {
        return titor;
    }

    public void setTitor(Titor titor) {
        this.titor = titor;
    }
}
