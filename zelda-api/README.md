# Compêndio de Hyrule - API The Legend of Zelda

Projeto Spring Boot com Maven, JPA, MySQL, Swagger e Frontend estático.

## Como executar

1. Certifique-se de que o **MySQL** está rodando localmente na porta `3306`.
2. Se necessário, ajuste usuário e senha do banco em `src/main/resources/application.properties`.
3. Importe a pasta `zelda-api` como projeto Maven na sua IDE (IntelliJ, Eclipse, VS Code) ou execute pelo terminal:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse:
   - **Frontend:** http://localhost:8080
   - **Swagger UI:** http://localhost:8080/swagger-ui/index.html
