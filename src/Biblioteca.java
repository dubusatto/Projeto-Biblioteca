import java.util.*;

class Biblioteca {
    // Atributos
    private LinkedList<Livro> livros;
    private HashMap<Livro, Set<Livro>> recomendacoes;

    // Construtor
    public Biblioteca() {
        livros = new LinkedList<Livro>();
        recomendacoes = new HashMap<>();
    }

    // Métodos
    @Override
    public String toString() { // Serve para mostrar as informações dos livros quando são adicionados, removidos e
        //buscados
        StringBuilder sb = new StringBuilder();
        for (Livro livro : livros) {
            sb.append(livro.toString()).append("\n");
        }
        return sb.toString();
    }
    public Livro adicionarLivro(String titulo, String autor, int anoPublicacao, String genero) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("O livro já está na biblioteca: " + titulo);
                return livro;  // Retorna o livro já existente
            }
        }

        Livro novoLivro = new Livro(titulo, autor, anoPublicacao, genero);
        livros.add(novoLivro);
        System.out.println("Livro adicionado com sucesso: " + novoLivro);
        return novoLivro;  // Retorna o novo livro criado
    }


    // Remover livros
    public void removerLivro(String tituloParaRemover) {
        boolean encontrado = false;  // Para verificar se o livro foi encontrado

        // Percorre a lista de livros
        System.out.print("\n===Removendo livro: '" + tituloParaRemover  + " ===\n");
        for (Livro livro : livros) {
            // Verifica se o título do livro é igual ao título a ser removido
            if (livro.getTitulo().equalsIgnoreCase(tituloParaRemover)) {
                livros.remove(livro);  // Remove o livro
                System.out.println("Livro removido com sucesso: " + tituloParaRemover);  // Mensagem de sucesso
                encontrado = true;
                break;  // Sai do loop, pois o livro já foi encontrado e removido
            }
        }

        // Se não encontrou o livro na lista
        if (!encontrado) {
            System.out.println("Livro não encontrado na biblioteca: " + tituloParaRemover);
        }
    }

    public Livro buscarLivro (String titulo) {
        System.out.print("\n===Buscando livro: '" + titulo + " ===\n");
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) { // Caso encontre o livro, irá mostrar as informações
                System.out.println(livro);
                return livro; // Retorna as informações do livro
            }
        }
        // Caso o livro não seja encontrado
        System.out.println("Livro não encontrado na biblioteca: " + titulo);
        return null;
    }
    // Métodos para adicionar recomendações de livros
    // Verifica se já existe alguma recomendação para o livro, se não existir ele cria.
    // Se já existir, ele adiciona o livro recomendado à lista de recomendações.
    public void adicionarRecomendacao(Livro base, Livro recomendado) {
        recomendacoes.computeIfAbsent(base, k -> new HashSet<>()).add(recomendado);
    }

    // Mostra as recomendações para um livro.
    public Set<Livro> obterRecomendacoes(Livro livro) {
        return recomendacoes.getOrDefault(livro, new HashSet<>());
    }
    public LinkedList<Livro> getLivros() {
        return livros;
    }
}