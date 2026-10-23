import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class TmdbApi {

    static String buscarJson(String titulo) {
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

    static ArrayList<Filme> buscarFilmes(String titulo) {
        ArrayList<Filme> lista = new ArrayList<>();
        String json = buscarJson(titulo);

        try {
            JsonObject resposta = JsonParser.parseString(json).getAsJsonObject();
            JsonArray resultados = resposta.getAsJsonArray("results");

            for (JsonElement elemento : resultados) {
                JsonObject filme = elemento.getAsJsonObject();

                String nome = filme.get("title").getAsString();
                double nota = filme.get("vote_average").getAsDouble();

                JsonElement dataJson = filme.get("release_date");
                if (dataJson == null || dataJson.isJsonNull()) {
                    continue;
                }
                String data = dataJson.getAsString();
                if (data.length() < 4) {
                    continue;
                }

                int ano = Integer.parseInt(data.substring(0, 4));
                lista.add(new Filme(nome, ano, nota));
            }
        } catch (RuntimeException e) {
            System.out.println("Nao foi possivel ler a resposta da API.");
        }

        return lista;
    }

    public static void main(String[] args) {
        for (Filme filme : buscarFilmes("matrix")) {
            filme.exibir();
        }
    }

}