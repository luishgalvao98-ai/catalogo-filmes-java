import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        ArrayList<Filme> catalogo = new ArrayList<>();

        catalogo.add(new Filme("Matrix", 1999, 8.7));
        catalogo.add(new Filme("Interestelar", 2014, 8.6));
        catalogo.add(new Filme("Parasita", 2019, 8.5));

        Scanner teclado = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("=== Menu ===");
            System.out.println("1 - Listar filmes");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    for (Filme filme : catalogo) {
                        filme.exibir();
                    }
                     break;
                case 0:
                    System.out.println("Ate logo!");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
        teclado.close();
    }

}