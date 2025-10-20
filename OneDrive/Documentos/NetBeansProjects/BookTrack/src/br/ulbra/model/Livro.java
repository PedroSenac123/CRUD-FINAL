
package br.ulbra.model;


public class Livro {
    private int id_livro;
    private String titulo;
    private String autor;
    private String genero;
    private String status_leitura;  // Ex: "Lendo", "Concluído", "Quero ler"
    private int progresso;          // Ex: porcentagem (0 a 100)
    private double nota;            // Ex: avaliação do livro (0 a 10)
    private int id_usuario;         // FK para o usuário dono do livro

    public Livro() {
    }

    public Livro(int id_livro, String titulo, String autor, String genero,
                 String status_leitura, int progresso, double nota, int id_usuario) {
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.status_leitura = status_leitura;
        this.progresso = progresso;
        this.nota = nota;
        this.id_usuario = id_usuario;
    }

    // Construtor alternativo (sem nota e progresso)
    public Livro(int id_livro, String titulo, String autor, String genero, int id_usuario) {
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.id_usuario = id_usuario;
    }
    

    // Getters
    public int getId_livro() {
        return id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getStatus_leitura() {
        return status_leitura;
    }

    public int getProgresso() {
        return progresso;
    }

    public double getNota() {
        return nota;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    // Setters
    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setStatus_leitura(String status_leitura) {
        this.status_leitura = status_leitura;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
