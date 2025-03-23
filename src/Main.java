public class Main {
    public static void main(String[] args) {

        Biblioteca novaBiblioteca = new Biblioteca();

        novaBiblioteca.adicionarLivro("O Senhor dos Anéis", "J.R.R. Tolkein", 1954);
        novaBiblioteca.adicionarLivro("1984", "George Orwell", 1949);
        novaBiblioteca.adicionarLivro("Pride and Prejudice", "Jane Austen", 1813);
        novaBiblioteca.adicionarLivro("1984", "George Orwell", 1949);
        novaBiblioteca.adicionarLivro("Pride and Prejudice", "Jane Austen", 1813);

        System.out.println(novaBiblioteca);

        novaBiblioteca.removerLivro("O Senhor dos Anéis");
        System.out.println(novaBiblioteca);

        novaBiblioteca.buscarLivro("1984");
        novaBiblioteca.buscarLivro("O Senhor dos Anéis");

        HistoricoDeNavegacao historicoUsuario1 = new HistoricoDeNavegacao();

        historicoUsuario1.adicionarNomeLivroNoHistorico("O Senhor dos Anéis");
        historicoUsuario1.adicionarNomeLivroNoHistorico("Pride and Prejudice");
        historicoUsuario1.adicionarNomeLivroNoHistorico("1984");

        historicoUsuario1.mostrarHistorico();

        FilaDeEmprestimo filaDeEmprestimos = new FilaDeEmprestimo();

        filaDeEmprestimos.mostrarReservas("1984");
        filaDeEmprestimos.adicionarUsuario("Eduardo", "1984");
        filaDeEmprestimos.adicionarUsuario("Maria", "Pride and Prejudice");
        filaDeEmprestimos.adicionarUsuario("Paulo", "1984");
        filaDeEmprestimos.adicionarUsuario("Pedro", "1984");
        filaDeEmprestimos.adicionarUsuario("Ana", "Pride and Prejudice");
        filaDeEmprestimos.mostrarReservas("1984");
        filaDeEmprestimos.mostrarReservas("Pride and Prejudice");
        filaDeEmprestimos.mostrarReservas("O Senhor dos Anéis: ");
    }
}