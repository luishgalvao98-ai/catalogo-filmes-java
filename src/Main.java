import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        ArrayList<Filme> catalogo = new ArrayList<>();

        catalogo.add(new Filme("Matrix", 1999, 8.7));
        catalogo.add(new Filme("Interestelar", 2014, 8.6));
        catalogo.add(new Filme("Parasita", 2019, 8.5));

        System.out.println("=== Meu Catalogo ===");

        for (Filme filme : catalogo) {
            filme.exibir();
        }
    }
}