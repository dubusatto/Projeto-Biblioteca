public class Reserva {
    private String nomeUsuario;
    private String nomeLivro;

    // Construtor
    public Reserva(String nomeDoUsuario, String nomeDoLivro) {
        this.nomeUsuario = nomeDoUsuario;
        this.nomeLivro = nomeDoLivro;
    }

    // Métodos getters
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }
}
