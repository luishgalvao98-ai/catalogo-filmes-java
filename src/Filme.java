public class Filme {

    String titulo;
    int ano;
    double nota;
    boolean favorito;

    public Filme(String titulo, int ano, double nota) {
        this.titulo = titulo;
        this.ano = ano;
        this.nota = nota;
    }

    public void exibir() {
        String marca = "";
        if (favorito) {
            marca = " [FAVORITO] ";
        }
        System.out.println(titulo + " (" + ano + ") - Nota: " + String.format("%.1f", nota) + marca);
    }
}
