import java.util.Stack;

public class HistoricoDeNavegacao {
    // Atributos
    private Stack<String> nomesLivros;

    // Construtor
    public HistoricoDeNavegacao() {
        nomesLivros = new Stack<>();
    }

    // Métodos
    public void adicionarNomeLivroNoHistorico(String nomeLivro) {
        nomesLivros.push(nomeLivro);
    }

    public void mostrarHistorico() {
        if (estaVazia()) {
            System.out.println("O histórico de navegação está vazio.");
            return;
        }
        System.out.println("\nHistórico de navegação :");
        // Percorrendo a pilha do topo para a base
        for (int i = nomesLivros.size() - 1; i >= 0; i--) {
            System.out.println(nomesLivros.get(i));
        }
    }

    // Verifica se a pilha nomesLivros está vazia
    public boolean estaVazia() {
        return nomesLivros.isEmpty();
    }
}

