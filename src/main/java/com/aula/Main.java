package com.aula;

public class Main
{
    public static void main( String[] args )
    {
        var biblioteca = new BibliotecaDAO(
            "jdbc:mysql://localhost/biblioteca?user=root&password=Atos@2022",
             "com.mysql.cj.jdbc.Driver");

        Livro livro = new Livro(30005, 2005,1,2,"HeronBombom");  
        

        //create
        //biblioteca.inserirLivro(livro);
        //read
        biblioteca.listarLivros();
        //update
        biblioteca.atualizarLivro(livro);      
        //delete
        biblioteca.excluirLivro(livro.getIsbn());

    }  
}
