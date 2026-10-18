public class Filme {

    String titulo;
    int ano;
    double nota;

    public Filme(String titulo, int ano, double nota) {
        this.titulo = titulo;
        this.ano = ano;
        this.nota = nota;
    }

    public void exibir() {
        System.out.println(titulo + " (" + ano + ") - Nota: " + nota);
    }
}
