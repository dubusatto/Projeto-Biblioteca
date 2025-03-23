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