public class Main {
    public static void main(String[] args) {

        Biblioteca novaBiblioteca = new Biblioteca();

        novaBiblioteca.adicionarLivro("Musashi 1", "Eiji Yoshikawa", 1584);
        novaBiblioteca.adicionarLivro("Perspective for Comic Book Artists", "David Chelsea", 1997);
        novaBiblioteca.adicionarLivro("Frame Perspective vol 2", "Marcos Mateu-Mestre", 2016);
        novaBiblioteca.adicionarLivro("O contador de histórias", "Dave Grohl", 2021);
        novaBiblioteca.adicionarLivro("Origem", "Dan Brown", 2017);
        novaBiblioteca.adicionarLivro("O Silmarilion", "J.R.R. Tolkien", 1977);
        novaBiblioteca.adicionarLivro("Frame Perspective vol 2", "Marcos Mateu-Mestre", 2016);
        novaBiblioteca.adicionarLivro("Musashi 2", "Eiji Yoshikawa", 1584);
        novaBiblioteca.adicionarLivro("Vida","Keith Richards", 2001);
        novaBiblioteca.adicionarLivro("Clapton", "Eric Clapton", 2000);
        novaBiblioteca.adicionarLivro("Guerra Civil", "Stuart Moore", 2010);
        novaBiblioteca.adicionarLivro("O ator invisível", "Yoshi Oida", 1530);
        novaBiblioteca.adicionarLivro("Seja Assertivo", "Vera Martins", 2014);

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