# Biblioteca de Filmes

Sistema de cadastro e gerenciamento de filmes desenvolvido com Spring Boot e JavaScript.

## Funcionalidades

- 🎬 Cadastrar novos filmes com título, gênero, ano e avaliação
- ✏️ Editar informações dos filmes cadastrados
- 🗑️ Excluir filmes da biblioteca
- ⭐ Sistema de avaliação por estrelas (1 a 5)
- 📊 Estatísticas: total de filmes e avaliação média
- 🎨 Interface moderna com tema de cinema

## Requisitos

- Maven (mvn)
- Java 11 ou superior

## Execução

Execute o comando:
```bash
./mvnw clean spring-boot:run
```

Acesse o front-end em: `http://localhost:8080/`

## Tecnologias

- **Back-end**: Spring Boot 2.4.1
- **Front-end**: HTML5, CSS3, JavaScript (Vanilla)
- **HTTP Client**: Axios

## Estrutura de Dados

Cada filme possui:
- **ID**: Identificador único (gerado automaticamente)
- **Título**: Nome do filme
- **Gênero**: Categoria do filme (Ação, Comédia, Drama, etc.)
- **Ano**: Ano de lançamento
- **Avaliação**: Nota de 1 a 5 estrelas
