import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Livro {
    // Atributos
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private Queue<Reserva> usuarios;


    // Construtor
    public Livro(String tituloLivro, String autorLivro, int anoPublicacaoLivro) {
        this.titulo = tituloLivro;
        this.autor = autorLivro;
        this.anoPublicacao = anoPublicacaoLivro;
        this.usuarios = new LinkedList<>();  // Inicializa a fila de usuários
    }

    // Esses métodos devem retornar as informações do livro
    @Override
    public String toString() { // Não sei se está correto, ainda vou testar para ver se mostra as informações.
        return String.format("Título: %s | Autor: %s | Ano: %d ", this.titulo, this.autor, this.anoPublicacao);
    }
    // Adiciona usuário na fila de reservas
    public void adicionarReserva(String nomeUsuario) {
        Reserva novaReserva = new Reserva(nomeUsuario, this.getTitulo());
        usuarios.add(novaReserva);
        System.out.println(nomeUsuario + " foi adicionado as reservas do livro " + this.getTitulo());
    }

    // Remove reserva de um determinado livro pq o primeiro usuário irá emprestá-lo
    public void removerReservaParaEmprestimo() {
        if (!usuarios.isEmpty()) {
            Reserva reservaRemovida = usuarios.poll(); // Remove o primeiro da fila
            System.out.println(reservaRemovida.getNomeUsuario() + " retirou o livro " + this.getTitulo());
        } else {
            System.out.println("Não há reservas para o livro " + this.getTitulo());
        }
    }
    // Remove reserva de um usuário específico
    public boolean removerReserva(String nomeUsuario) {
        Iterator<Reserva> iterator = usuarios.iterator();

        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.getNomeUsuario().equals(nomeUsuario)) {
                iterator.remove(); // Removendo de forma segura
                System.out.println(nomeUsuario + " teve sua reserva removida para o livro " + this.getTitulo());
                return true; // Retorna imediatamente após remover
            }
        }

        // Caso o usuário não tenha sido encontrado
        System.out.println("Usuário " + nomeUsuario + " não encontrado na fila de reservas para o livro " + this.getTitulo());
        return false;
    }



    // Mostra todas as reservas de um determinado livro
    public void mostrarReservas() {
        if (usuarios.isEmpty()) { // testa se a fila usuários está vazia
            System.out.println("\nNenhuma reserva para o livro: " + this.titulo);
            return;
        }
        // caso não esteja vazia ele irá as reservas da fila reserva associadas aquele titulo de livro
        System.out.println("\nReservas para o livro: " + this.titulo);
        for (Reserva reserva : usuarios) {
            System.out.println("  " + reserva.getNomeUsuario());
        }
    }
    public String getTitulo() {
        return this.titulo;
    }
}