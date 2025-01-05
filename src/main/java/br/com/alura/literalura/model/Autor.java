package br.com.alura.literalura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private LocalDate dataMorte;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livros> livro;

    public Autor(){

    }
    public Autor(DadosAutor autor) {
        this.nome = autor.nome();
        this.dataNascimento = autor.dataNascimento();
        this.dataMorte = autor.dataMorte();
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(LocalDate dataMorte) {
        this.dataMorte = dataMorte;
    }

    public List<Livros> getLivro() {
        return livro;
    }

    public void setLivro(List<Livros> livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return
                " Nome do Autor: '" + nome +
                ", Data de Nascimento: " + dataNascimento +
                ", Data da Morte: " + dataMorte +
                ", Livro: " + livro ;
    }
}
