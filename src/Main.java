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
            System.out.println("2 - Adicionar filme");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    for (Filme filme : catalogo) {
                        filme.exibir();
                    }
                     break;
                case 2:
                    teclado.nextLine();
                    System.out.println("Titulo: ");
                    String titulo = teclado.nextLine();
                    System.out.println("Ano: ");
                    int ano = teclado.nextInt();
                    System.out.print("Nota (use virgula, ex: 8,9): ");
                    double nota = teclado.nextDouble();
                    catalogo.add(new Filme(titulo, ano, nota));
                    System.out.println("Filme adicionado!");
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