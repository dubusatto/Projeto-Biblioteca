public class NoDeLivro {
    Livro livro;
    NoDeLivro esquerda;
    NoDeLivro direita;

    public NoDeLivro(Livro livro) {
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }


}
