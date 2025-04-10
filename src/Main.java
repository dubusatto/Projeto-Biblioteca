import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Biblioteca novaBiblioteca = new Biblioteca();

        // Adicionando livros à biblioteca
        Livro livroMusashi1 = novaBiblioteca.adicionarLivro("Musashi 1", "Eiji Yoshikawa", 1584, "épico");
        Livro livroPerspective = novaBiblioteca.adicionarLivro("Perspective for Comic Book Artists", "David Chelsea", 1997, "desenho");
        Livro livroFrame2 = novaBiblioteca.adicionarLivro("Frame Perspective vol 2", "Marcos Mateu-Mestre", 2016, "desenho");
        Livro livroOContador = novaBiblioteca.adicionarLivro("O contador de histórias", "Dave Grohl", 2021, "biografia");
        Livro livroOrigem = novaBiblioteca.adicionarLivro("Origem", "Dan Brown", 2017, "ação");
        Livro livroOSilmarilion = novaBiblioteca.adicionarLivro("O Silmarilion", "J.R.R. Tolkien", 1977, "fantasia");
        Livro livroMusashi2 = novaBiblioteca.adicionarLivro("Musashi 2", "Eiji Yoshikawa", 1584, "épico");
        Livro livroVida = novaBiblioteca.adicionarLivro("Vida", "Keith Richards", 2001, "biografia");
        Livro livroClapton = novaBiblioteca.adicionarLivro("Clapton", "Eric Clapton", 2000, "biografia");
        Livro livroGuerraCivil = novaBiblioteca.adicionarLivro("Guerra Civil", "Stuart Moore", 2010, "comic");
        Livro livroOAtorInvisivel = novaBiblioteca.adicionarLivro("O ator invisível", "Yoshi Oida", 1530, "dramaturgia");
        Livro livroSejaAssertivo = novaBiblioteca.adicionarLivro("Seja Assertivo", "Vera Martins", 2014, "auto-ajuda");

        // Removendo um livro da biblioteca
        novaBiblioteca.removerLivro("O Senhor dos Anéis");
        novaBiblioteca.removerLivro("Seja Assertivo");

        // Mostrando os livros adicionados à biblioteca
        novaBiblioteca.buscarLivro("1984");
        novaBiblioteca.buscarLivro("O Senhor dos Anéis");

        // Criando um histórico de navegação para o usuário
        HistoricoDeNavegacao historicoUsuario1 = new HistoricoDeNavegacao();

        historicoUsuario1.adicionarNomeLivroNoHistorico("O Senhor dos Anéis");
        historicoUsuario1.adicionarNomeLivroNoHistorico("Pride and Prejudice");
        historicoUsuario1.adicionarNomeLivroNoHistorico("1984");

        historicoUsuario1.mostrarHistorico();

        // Testando reservas
        if (livroOSilmarilion != null) {
            livroOSilmarilion.adicionarReserva("Professor Wellington");
            livroOSilmarilion.adicionarReserva("Eduardo");
            livroOSilmarilion.adicionarReserva("Ricardo");
            livroOSilmarilion.adicionarReserva("Isaías");
            livroOSilmarilion.mostrarReservas();

            livroOSilmarilion.removerReserva("Ricardo");
            livroOSilmarilion.mostrarReservas();

            livroOSilmarilion.removerReservaParaEmprestimo();
            livroOSilmarilion.mostrarReservas();

        }

        // Adicionando recomendações
        novaBiblioteca.adicionarRecomendacao(livroMusashi1, livroMusashi2);  // Musashi 1 -> Musashi2
        novaBiblioteca.adicionarRecomendacao(livroMusashi1, livroGuerraCivil);  // Musashi 1 -> Guerra Civil
        novaBiblioteca.adicionarRecomendacao(livroOSilmarilion, livroMusashi1);
        novaBiblioteca.adicionarRecomendacao(livroOSilmarilion, livroGuerraCivil);  // O Silmarilion -> Guerra Civil
        novaBiblioteca.adicionarRecomendacao(livroPerspective, livroFrame2);
        novaBiblioteca.adicionarRecomendacao(livroPerspective, livroVida);
        novaBiblioteca.adicionarRecomendacao(livroOContador, livroVida);
        novaBiblioteca.adicionarRecomendacao(livroOContador, livroClapton);
        novaBiblioteca.adicionarRecomendacao(livroVida, livroOContador);
        novaBiblioteca.adicionarRecomendacao(livroVida, livroClapton);
        novaBiblioteca.adicionarRecomendacao(livroClapton, livroOContador);
        novaBiblioteca.adicionarRecomendacao(livroClapton, livroVida);
        novaBiblioteca.adicionarRecomendacao(livroOAtorInvisivel, livroSejaAssertivo);
        novaBiblioteca.adicionarRecomendacao(livroOAtorInvisivel, livroFrame2);
        novaBiblioteca.adicionarRecomendacao(livroFrame2, livroPerspective);
        novaBiblioteca.adicionarRecomendacao(livroFrame2, livroOAtorInvisivel);
        novaBiblioteca.adicionarRecomendacao(livroSejaAssertivo, livroFrame2);
        novaBiblioteca.adicionarRecomendacao(livroSejaAssertivo, livroOAtorInvisivel);
        novaBiblioteca.adicionarRecomendacao(livroGuerraCivil, livroMusashi1);
        novaBiblioteca.adicionarRecomendacao(livroGuerraCivil, livroMusashi2);
        novaBiblioteca.adicionarRecomendacao(livroMusashi2, livroGuerraCivil);
        novaBiblioteca.adicionarRecomendacao(livroMusashi2, livroOSilmarilion);
        novaBiblioteca.adicionarRecomendacao(livroOrigem, livroVida);
        novaBiblioteca.adicionarRecomendacao(livroOrigem, livroOContador);

        // Criação de usuários e adição de histórico de leitura para testar recomendações
        Usuario usuario1 = new Usuario("Eduardo Busatto", 1672); // criação do usuário

        // Adicionando livros ao histórico do usuário
        usuario1.adicionarAoHistorico(livroMusashi1);
        usuario1.adicionarAoHistorico(livroOSilmarilion);
        usuario1.adicionarAoHistorico(livroOrigem);

        // Chamando o método para recomendar livros com base no histórico de leitura do usuário
        usuario1.mostrarRecomendacoesPorHistorico(novaBiblioteca);

        Usuario usuario2 = new Usuario("Davi Dias", 1673); // criação do usuário

        // Adicionando livros ao histórico do usuário
        usuario2.adicionarAoHistorico(livroOrigem);
        usuario2.adicionarAoHistorico(livroFrame2);
        usuario2.adicionarAoHistorico(livroGuerraCivil);

        // Chamando o método para recomendar livros com base no histórico de leitura do usuário
        usuario2.mostrarRecomendacoesPorHistorico(novaBiblioteca);

        // Testar a inserção de livros na árvore
        ArvoreDeLivro arvoreDeLivros = new ArvoreDeLivro();
        // Percorre a LinkedList que os livros foram armazenados na classe Biblioteca para ir adicionando na árvore
        for (Livro livro : novaBiblioteca.getLivros()) {
            arvoreDeLivros.inserirNoDeLivro(livro);
        }
        // Mostrar a árvore pra ver se foi tudo certinho
        arvoreDeLivros.mostrar();

        // Testar busca
        arvoreDeLivros.buscarNoDeLivro(livroFrame2);

        // Testar remoção
        arvoreDeLivros.removerNoDeLivro(livroOContador); // Remoção do livro O contador de histórias

        arvoreDeLivros.mostrar(); // Mostrando a árvore agora sem o livro O contador de histórias

        arvoreDeLivros.buscarNoDeLivro(livroOContador); // Buscando o livro que foi removido
    }
}

