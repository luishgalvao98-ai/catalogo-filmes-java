# Catálogo de Filmes em Java

Programa de console para gerenciar um catálogo de filmes, feito em Java como projeto de estudo e portfólio. Os filmes podem ser buscados na internet pela API do TMDB.

## O que o programa faz

- Lista os filmes do catálogo
- Adiciona filmes manualmente (título, ano e nota)
- Busca filmes do catálogo por parte do título
- Filtra filmes por nota mínima
- Busca filmes na internet (API do TMDB) e adiciona ao catálogo
- Marca filmes como favoritos e lista só os favoritos (salvos no arquivo)
- Salva os filmes no arquivo `filmes.txt` ao sair e carrega ao iniciar
- Valida a digitação: se for digitada uma letra onde se espera um número, o programa avisa e pergunta de novo

## Exemplo de uso

```
=== Menu ===
1 - Listar filmes
2 - Adicionar filme
3 - Buscar por titulo
4 - Listar por nota minima
5 - Buscar na internet
6 - Marcar/desmarcar favorito
7 - Listar favoritos
0 - Sair
```

## Tecnologias

- Java 21 ou superior
- Maven
- Gson (leitura de JSON)
- API do TMDB
- IntelliJ IDEA
- Git e GitHub

## Como rodar

1. Instale o JDK (Java 21 ou superior) e o IntelliJ IDEA
2. Clone o repositório: `git clone https://github.com/luishgalvao98-ai/catalogo-filmes-java.git`
3. Abra a pasta do projeto no IntelliJ. Ele reconhece o `pom.xml` e baixa as bibliotecas sozinho
4. Para usar a opção 5 (busca na internet), crie uma conta gratuita no [TMDB](https://www.themoviedb.org), gere uma chave de API e salve essa chave em um arquivo `chave.txt` na pasta principal do projeto (só a chave, em uma linha). Esse arquivo é ignorado pelo Git. Sem a chave, as demais opções continuam funcionando
5. Execute a classe `Main`

## Créditos

Este produto usa a API do TMDB, mas não é endossado nem certificado pelo TMDB. Os dados de filmes vêm do [TMDB](https://www.themoviedb.org).

## Próximos passos

- [x] Buscar filmes reais pela API do TMDB
- [x] Lista de favoritos
- [x] Arredondar as notas para uma casa decimal
- [ ] Versão web com Spring Boot