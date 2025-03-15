import java.util.LinkedList;

class Livro {
    // Atributos
    String titulo;
    String autor;
    int anoPublicacao;

    // Construtor
    public Livro(String tituloLivro, String autorLivro, int anoPublicacaoLivro) {
        this.titulo = tituloLivro;
        this.autor = autorLivro;
        this.anoPublicacao = anoPublicacaoLivro;
    }

    // Esse métodos deve retornar as informações do livro
    @Override
    public String toString() { // Não sei se está correto, ainda vou testar para ver se mostra as informações.
        return String.format("Título: %s | Autor: %s | Ano: %d ", this.titulo, this.autor, this.anoPublicacao);
    }

    // Getters
    public String getTitulo() {
        return this.titulo;
    }
}

class Biblioteca {
    // Atributos
    private LinkedList<Livro> livros;

    // Construtor
    public Biblioteca() {
        livros = new LinkedList<Livro>();
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
    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        boolean encontrado = false;  // Variável começa como false para que o código siga em frente

        // Percorre a lista de livros
        for (Livro livro : livros) {
            // Verifica se o título do livro é igual ao título a ser adicionado
            if (livro.getTitulo().equals(titulo)) {
                encontrado = true; // Se encontrar o livro não adiciona e avisa o usuário dessa situação
                System.out.println("O livro já está na biblioteca: " + titulo);
               break;
            }
        }
        if (!encontrado) { // Se não encontrar, cria uma nova instância de Livro e adiciona na Biblioteca
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao);
        livros.add(novoLivro);
        System.out.println("Livro adicionado com sucesso: " + novoLivro);
        System.out.println(this);  // Imprime a biblioteca atualizada
        }
    }


    // Remover livros
    public void removerLivro(String tituloParaRemover) {
        boolean encontrado = false;  // Para verificar se o livro foi encontrado

        // Percorre a lista de livros
        for (Livro livro : livros) {
            // Verifica se o título do livro é igual ao título a ser removido
            if (livro.getTitulo().equals(tituloParaRemover)) {
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

    public String buscarLivro (String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) { // Caso encontre o livro, irá mostrar as informações
                System.out.println(livro);
                return livro.toString(); // Retorna as informações do livro
            }
        }
    // Caso o livro não seja encontrado
    System.out.println("Livro não encontrado na biblioteca: " + titulo);
    return null;
    }
}

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