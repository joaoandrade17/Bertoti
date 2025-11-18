# Configuração do banco (MySQL) e build

## Pré-requisitos
- MySQL instalado e em execução (porta 3306)
- JDK 21 instalado (necessário para compilar/rodar)

## Criar o banco `db_book`
No MySQL, execute:
```sql
CREATE DATABASE db_book CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
```

Opcionalmente, criar um usuário dedicado:
```sql
CREATE USER 'book_user'@'localhost' IDENTIFIED BY 'senha_segura';
GRANT ALL PRIVILEGES ON db_book.* TO 'book_user'@'localhost';
FLUSH PRIVILEGES;
```

Depois, ajuste `src/main/resources/application.properties` conforme seu usuário/senha:
```
spring.datasource.url=jdbc:mysql://localhost:3306/db_book
spring.datasource.username=root
spring.datasource.password=
```

A tabela `books` é criada automaticamente via `schema.sql` ao iniciar a aplicação.

## Configurar JAVA_HOME (Windows PowerShell)
Substitua o caminho abaixo pelo diretório do seu JDK 21:
```powershell
$env:JAVA_HOME = "C:\\Program Files\\Java\\jdk-21"
$env:Path = "$env:JAVA_HOME\\bin;$env:Path"
```

## Build e execução
Dentro desta pasta (`sbur-rest-demo`):
```powershell
.\\mvnw.cmd -DskipTests clean package
.\\mvnw.cmd spring-boot:run
```

## Endpoints (exemplos)
- GET todos: `GET http://localhost:8080/books`
- GET por id: `GET http://localhost:8080/books/{id}`
- POST criar:
```json
{
  "name": "Dom Casmurro"
}
```
- PUT atualizar por id:
```json
{
  "name": "Memórias Póstumas de Brás Cubas"
}
```
- DELETE por id: `DELETE http://localhost:8080/books/{id}`


