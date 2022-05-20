package com.aula;

public class Livro {
    private int isbn, ano, categoria_id, editora_id;
    private String titulo;

    public int getCategoria_id() {
        return categoria_id;
    }

    public Livro(int isbn, int ano, int categoria_id, int editora_id, String titulo) {
        this.isbn = isbn;
        this.ano = ano;
        this.categoria_id = categoria_id;
        this.editora_id = editora_id;
        this.titulo = titulo;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getEditora_id() {
        return editora_id;
    }

    public void setEditora_id(int editora_id) {
        this.editora_id = editora_id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
