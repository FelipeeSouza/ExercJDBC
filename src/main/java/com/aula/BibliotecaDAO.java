package com.aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BibliotecaDAO {
    private Connection conn;

    public BibliotecaDAO(String uri, String driver) {
        try { 
            Class.forName(driver);
            this.conn = DriverManager.getConnection(uri);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Read
    public void listarLivros() {
        String query = "SELECT * FROM `livro`";

        try {
            ResultSet rs = conn.createStatement().executeQuery(query);

            while(rs.next()) {
                int isbn = rs.getInt("isbn");
                String titulo = rs.getString("titulo");
                int ano = rs.getInt("ano");

                System.out.printf("%d %s %d\n", isbn, titulo, ano);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Create
    public void inserirLivro(Livro livro) {
        String query = "INSERT INTO `livro` (`isbn`,`titulo`,`ano`,`Categoria_id`,`Editora_id`) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, livro.getIsbn());
            pst.setString(2, livro.getTitulo());
            pst.setInt(3, livro.getAno());
            pst.setInt(4, livro.getCategoria_id());
            pst.setInt(5, livro.getEditora_id());

            pst.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Update
    public void atualizarLivro(Livro livro) {
        String query = "UPDATE `livro` SET `isbn`=?, `titulo`=?, `ano`=?, `Categoria_id`=?, `Editora_id`=? WHERE `isbn`=?";

        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, livro.getIsbn());
            pst.setString(2, livro.getTitulo());
            pst.setInt(3, livro.getAno());
            pst.setInt(4, livro.getCategoria_id());
            pst.setInt(5, livro.getEditora_id());
            pst.setInt(6, livro.getIsbn());
            
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Delete
    public void excluirLivro(int isbn) {
        String query = "DELETE FROM livro WHERE `isbn`=?";

        try {
            var pst = conn.prepareStatement(query);
            pst.setInt(1, isbn);
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
