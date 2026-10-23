import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Filme> catalogo = carregar();

        if (catalogo.isEmpty()) {
            catalogo.add(new Filme("Matrix", 1999, 8.7));
            catalogo.add(new Filme("Interestelar", 2014, 8.6));
            catalogo.add(new Filme("Parasita", 2019, 8.5));
        }

        Scanner teclado = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("=== Menu ===");
            System.out.println("1 - Listar filmes");
            System.out.println("2 - Adicionar filme");
            System.out.println("3 - Buscar por titulo");
            System.out.println("4 - Listar por nota minima");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = lerInt(teclado);

            switch (opcao) {
                case 1:
                    for (Filme filme : catalogo) {
                        filme.exibir();
                    }
                    break;
                case 2:
                    System.out.println("Titulo: ");
                    String titulo = teclado.nextLine();
                    System.out.println("Ano: ");
                    int ano = lerInt(teclado);
                    System.out.print("Nota (use virgula, ex: 8,9): ");
                    double nota = lerDouble(teclado);
                    catalogo.add(new Filme(titulo, ano, nota));
                    System.out.println("Filme adicionado!");
                    break;
                case 3:
                    System.out.print("Digite parte do titulo: ");
                    String busca = teclado.nextLine();
                    boolean achou = false;
                    for (Filme filme : catalogo) {
                        if (filme.titulo.toLowerCase().contains(busca.toLowerCase())) {
                            filme.exibir();
                            achou = true;
                        }
                    }
                    if (!achou) {
                        System.out.println("Nenhum filme encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nota minima: ");
                    double minima = lerDouble(teclado);
                    boolean encontrou = false;
                    for (Filme filme : catalogo) {
                        if (filme.nota >= minima) {
                            filme.exibir();
                            encontrou = true;
                        }
                    }
                    if (!encontrou) {
                        System.out.println("Nenhum filme com essa nota.");
                    }
                    break;
                case 0:
                    salvar(catalogo);
                    System.out.println("Ate logo!");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
        teclado.close();
    }

    static void salvar(ArrayList<Filme> catalogo) {
        ArrayList<String> linhas = new ArrayList<>();

        for (Filme filme : catalogo) {
            linhas.add(filme.titulo + ";" + filme.ano + ";" + filme.nota);
        }

        try {
            Files.write(Path.of("filmes.txt"), linhas);
            System.out.println("Filmes salvos em filmes.txt");
        } catch (IOException e) {
            System.out.println("Nao foi possivel salvar o arquivo.");
        }
    }

    static ArrayList<Filme> carregar() {
        ArrayList<Filme> catalogo = new ArrayList<>();
        Path arquivo = Path.of("filmes.txt");

        if (Files.exists(arquivo)) {
            try {
                List<String> linhas = Files.readAllLines(arquivo);

                for (String linha : linhas) {
                    String[] partes = linha.split(";");

                    if (partes.length < 3) {
                        continue;
                    }

                    String titulo = partes[0];
                    int ano = Integer.parseInt(partes[1]);
                    double nota = Double.parseDouble(partes[2]);
                    catalogo.add(new Filme(titulo, ano, nota));
                }
            } catch (IOException e) {
                System.out.println("Nao foi possivel ler o arquivo.");
            }
        }

        return catalogo;
    }

    static int lerInt(Scanner teclado) {
        while (true) {
            String texto = teclado.nextLine();
            try {
                return Integer.parseInt(texto.trim());
            } catch (NumberFormatException e) {
                System.out.print("Valor invalido. Digite um numero inteiro: ");
            }
        }
    }

    static double lerDouble(Scanner teclado) {
        while (true) {
            String texto = teclado.nextLine();
            try {
                return Double.parseDouble(texto.trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.print("Valor invalido. Digite um numero (ex: 8,9): ");
            }
        }
    }

}