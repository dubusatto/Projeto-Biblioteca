public class ArvoreDeLivro {
    private NoDeLivro raiz;

    public ArvoreDeLivro() {
        this.raiz = null;
    }

    public void inserirNoDeLivro(Livro livro) {
        raiz = inserirNoDeLivroRecursivo(raiz, livro);
    }

    private NoDeLivro inserirNoDeLivroRecursivo(NoDeLivro atual, Livro livro) {
        if (atual == null) {
            return new NoDeLivro(livro);
        }
        // O compareTo irá comparar as primeiras letras dos titulos usando o sistema ASCII
        int comparacaoDeTitulos = livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo());

        if (comparacaoDeTitulos < 0) { // negativo significa que o novo livro começa com uma letra menor que o pai
            atual.esquerda = inserirNoDeLivroRecursivo(atual.esquerda, livro);
        } else if (comparacaoDeTitulos > 0) { // positivo significa que o novo livro começa com uma letra maior que o pai
            atual.direita = inserirNoDeLivroRecursivo(atual.direita, livro);
        } else { // todas as letras foram comparadas e é o mesmo título
            System.out.println("O livro já está na árvore: " + livro.getTitulo());
        }
        return atual; // O livro não é inserido pois o título do pai é o mesmo significando que é o mesmo livro
    }

    // Mostrar árvore em preordem
    public void mostrar() {
        mostrarRecursivo(raiz, 0);
    }

    private void mostrarRecursivo(NoDeLivro atual, int nivel) {
        if (atual != null) {
            if (nivel > 0) {
                System.out.print("     ".repeat(nivel - 1) + "└----");
            }

            System.out.println(atual.livro.getTitulo());
            // Para cada nível, aumentamos o nível para os nós filhos
            mostrarRecursivo(atual.esquerda, nivel + 1);
            mostrarRecursivo(atual.direita, nivel + 1);
        }
    }

    private Livro buscarMaiorLivro(NoDeLivro raiz) { // O valor que se refere é do caracter no sistema ASCII
        return raiz.direita == null
                ? raiz.livro // Se o nó direito for nulo, o maior valor é o próprio nó
                : buscarMaiorLivro(raiz.direita); // Caso contrário, vamos recursivamente para a direita até encotrar
    }

    public boolean buscarNoDeLivro(Livro livro) {
        return buscarNoDeLivroRecursivo(raiz, livro);
    }

    private boolean buscarNoDeLivroRecursivo(NoDeLivro atual, Livro livro) {
        if (atual == null) {
            System.out.println("Livro '" + livro.getTitulo() + "' não encontrado.");
            return false; // Livro não encontrado, retorna false
        }

        // Comparação entre o título do livro que estamos procurando e o título do nó atual
        int comparacaoDeTitulos = livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo());

        if (livro.getTitulo().equals(atual.livro.getTitulo())) {
            System.out.println("Livro '" + livro.getTitulo() + "' encontrado com sucesso.");
            return true; // Livro encontrado
        }
        if (comparacaoDeTitulos < 0) { // O título do livro a ser buscado é menor
            return buscarNoDeLivroRecursivo(atual.esquerda, livro); // Vamos para a esquerda
        } else if (comparacaoDeTitulos > 0) { // O título do livro a ser buscado é maior
            return buscarNoDeLivroRecursivo(atual.direita, livro); // Vamos para a direita
        }
        return false; // Caso não encontre o livro
    }

    public void removerNoDeLivro(Livro livro) {
        raiz = removerNoDeLivroRecursivo(raiz, livro);
    }

    private NoDeLivro removerNoDeLivroRecursivo(NoDeLivro atual, Livro livro) {
        if (atual == null) {
            return null; // Nó não encontrado
        }

        if (livro.getTitulo().equalsIgnoreCase(atual.livro.getTitulo())) {
            // Caso 1: sem filhos
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            // Caso 2: um filho
            if (atual.esquerda == null) {
                return atual.direita;
            }
            if (atual.direita == null) {
                return atual.esquerda;
            }

            // Caso 3: dois filhos
            Livro maiorLivro = buscarMaiorLivro(atual.esquerda); // retorna o objeto Livro
            atual.livro = maiorLivro; // substitui o conteúdo do nó atual
            atual.esquerda = removerNoDeLivroRecursivo(atual.esquerda, maiorLivro); // remove o nó duplicado
            return atual;
        }

        if (livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) < 0) {
            atual.esquerda = removerNoDeLivroRecursivo(atual.esquerda, livro);
            return atual;
        }

        atual.direita = removerNoDeLivroRecursivo(atual.direita, livro);
        return atual;
    }
}









