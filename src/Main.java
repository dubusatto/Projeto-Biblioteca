

public class Main {
    public static void main(String[] args) {

        Biblioteca novaBiblioteca = new Biblioteca();

        novaBiblioteca.adicionarLivro("O Senhor dos Anéis", "J.R.R. Tolkein", 1954);
        novaBiblioteca.adicionarLivro("1984", "George Orwell", 1949);
        novaBiblioteca.adicionarLivro("Pride and Prejudice", "Jane Austen", 1813);
        novaBiblioteca.adicionarLivro("1984", "George Orwell", 1949);
        System.out.println(novaBiblioteca);

        novaBiblioteca.removerLivro("O Senhor dos Anéis");
        System.out.println(novaBiblioteca);

        novaBiblioteca.buscarLivro("1984");
        novaBiblioteca.buscarLivro("O Senhor dos Anéis");


    }
}