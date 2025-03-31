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
        novaBiblioteca.adicionarLivro("Vida", "Keith Richards", 2001);
        novaBiblioteca.adicionarLivro("Clapton", "Eric Clapton", 2000);
        novaBiblioteca.adicionarLivro("Guerra Civil", "Stuart Moore", 2010);
        novaBiblioteca.adicionarLivro("O ator invisível", "Yoshi Oida", 1530);
        novaBiblioteca.adicionarLivro("Seja Assertivo", "Vera Martins", 2014);



        novaBiblioteca.removerLivro("O Senhor dos Anéis");


        novaBiblioteca.buscarLivro("1984");
        novaBiblioteca.buscarLivro("O Senhor dos Anéis");

        HistoricoDeNavegacao historicoUsuario1 = new HistoricoDeNavegacao();

        historicoUsuario1.adicionarNomeLivroNoHistorico("O Senhor dos Anéis");
        historicoUsuario1.adicionarNomeLivroNoHistorico("Pride and Prejudice");
        historicoUsuario1.adicionarNomeLivroNoHistorico("1984");

        historicoUsuario1.mostrarHistorico();

        // Buscar livros
        Livro livro = novaBiblioteca.buscarLivro("O Silmarilion");  // Não deve encontrar, pois foi removido

        // Testando reservas
        if (livro != null) {
            livro.adicionarReserva("Usuário1");
            livro.adicionarReserva("Usuário2");
            livro.mostrarReservas();

            livro.removerReserva("Usuário1");
            livro.mostrarReservas();
        }

        // Exemplo de histórico de navegação
        historicoUsuario1 = new HistoricoDeNavegacao();
        historicoUsuario1.adicionarNomeLivroNoHistorico("O Senhor dos Anéis");
        historicoUsuario1.adicionarNomeLivroNoHistorico("1984");
        historicoUsuario1.mostrarHistorico();

        // Reservando livros para usuários
        novaBiblioteca.reservarLivro("Musashi 1", "Usuário1");
        novaBiblioteca.reservarLivro("Musashi 1", "Usuário2");
        novaBiblioteca.reservarLivro("Perspective for Comic Book Artists", "Usuário3");

        // Mostrando as reservas dos livros
        novaBiblioteca.mostrarReservasDoLivro("Musashi 1");  // Exibe as reservas para "Musashi 1"
        novaBiblioteca.mostrarReservasDoLivro("Perspective for Comic Book Artists");  // Exibe as reservas para o outro livro

        // Cancelando uma reserva de um usuário
        novaBiblioteca.cancelarReservaLivro("Musashi 1", "Usuário1");

        // Mostrando as reservas após o cancelamento
        novaBiblioteca.mostrarReservasDoLivro("Musashi 1");

        // Retirando um livro para emprestimo (remove o primeiro da fila)
        novaBiblioteca.retirarLivro("Musashi 1");

        // Mostrando as reservas após a retirada do livro
        novaBiblioteca.mostrarReservasDoLivro("Musashi 1");
    }
}




        /*

        Livro filaDeEmprestimos = new FilaDeEmprestimo();

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

         */