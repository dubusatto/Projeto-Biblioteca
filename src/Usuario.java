import java.util.*;

public class Usuario {
    private String nome;
    private int id;
    private List<Livro> historicoLeitura;
    private Queue<Livro> livrosReservados;

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.historicoLeitura = new ArrayList<>();
        this.livrosReservados = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public List<Livro> getHistoricoLeitura() {
        return historicoLeitura;
    }

    public Queue<Livro> getLivrosReservados() {
        return livrosReservados;
    }

    public void adicionarAoHistorico(Livro livro) {
        historicoLeitura.add(livro);
    }

    public void mostrarRecomendacoesPorHistorico(Biblioteca biblioteca) {
        System.out.print("\n=== Sugestões de leitura ===\n");
        System.out.print("Usuário: " + getNome() + "\n");
        for (Livro livroLido : historicoLeitura) {
            Set<Livro> recomendacoes = biblioteca.obterRecomendacoes(livroLido);
            if (!recomendacoes.isEmpty()) {
                System.out.println("Porque você leu o livro '" + livroLido.getTitulo() + "', recomendamos:");
                for (Livro livroRecomendado : recomendacoes) {
                    System.out.println("- " + livroRecomendado.getTitulo());
                }
            } else {
                System.out.println("Nenhuma recomendação encontrada para '" + livroLido.getTitulo() + "'.");
            }
        }
    }
}