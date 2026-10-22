import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TmdbApi {

    static String buscarFilmes(String titulo) {
        try {
            String chave = Files.readString(Path.of("chave.txt")).trim();
            String busca = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
            String endereco = "https://api.themoviedb.org/3/search/movie?api_key=" + chave
                    + "&query=" + busca + "&language=pt-BR";

            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest pedido = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> resposta = cliente.send(pedido, HttpResponse.BodyHandlers.ofString());
            return resposta.body();
        } catch (IOException | InterruptedException e) {
            return "Erro ao acessar a API.";
        }
    }

    public static void main(String[] args) {
        System.out.println(buscarFilmes("matrix"));
    }
}