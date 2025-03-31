import java.util.LinkedList;

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

    public Livro buscarLivro (String titulo) {
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

    public void reservarLivro(String tituloLivro, String nomeUsuario) {
        Livro livro = buscarLivro(tituloLivro);
        if (livro != null) {
            livro.adicionarReserva(nomeUsuario);  // Adiciona a reserva ao livro encontrado
        } else {
            System.out.println("Livro '" + tituloLivro + "' não encontrado.");
        }
    }

    public void cancelarReservaLivro(String tituloLivro, String nomeUsuario) {
        Livro livro = buscarLivro(tituloLivro);
        if (livro != null) {
            livro.removerReserva(nomeUsuario);
        } else {
            System.out.println("Livro '" + tituloLivro + "' não encontrado.");
        }
    }

    public void retirarLivro(String tituloLivro) {
        Livro livro = buscarLivro(tituloLivro);
        if (livro != null) {
            livro.removerReservaParaEmprestimo();
        } else {
            System.out.println("Livro '" + tituloLivro + "' não encontrado.");
        }
    }

    public void mostrarReservasDoLivro(String tituloLivro) {
        Livro livro = buscarLivro(tituloLivro);
        if (livro != null) {
            livro.mostrarReservas();
        } else {
            System.out.println("Livro '" + tituloLivro + "' não encontrado.");
        }
    }


}