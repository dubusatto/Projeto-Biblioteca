import java.util.LinkedList;
import java.util.Queue;

class FilaDeEmprestimo {
    private Queue<Reserva> filaDeUsuarios;  // Atributo para armazenar os livros em uma fila

    // Construtor
    public FilaDeEmprestimo() {
        filaDeUsuarios = new LinkedList<>();  // Inicializa a fila de usuários
    }

    // Métodos

    // Adicionar usuário na lista de reserva
    public void adicionarUsuario(String nomeUsuario, String nomeLivro) {
        Reserva novaReserva = new Reserva(nomeUsuario, nomeLivro);
        filaDeUsuarios.add(novaReserva);
    }

    public void mostrarReservas(String nomeDoLivro) {
        boolean encontrouReserva = false; // Inicia a varíavel false para seguir no código

        for (Reserva reserva : filaDeUsuarios) {
            if (reserva.getNomeLivro().equals(nomeDoLivro)) {
                if (!encontrouReserva) {
                    System.out.println("\n" + reserva.getNomeLivro() + " reservado por: ");
                    encontrouReserva = true;  // Marca que encontrou uma reserva e não repetirá o nome do livro
                }
                System.out.println("  " + reserva.getNomeUsuario());  // Indenta o nome do usuário
            }
        }

        if (!encontrouReserva) {
            System.out.println("\n" + nomeDoLivro + "\nNenhuma reserva para este livro.");
        }
    }
}