# ForumHub
 
# Forum API

API REST para gerenciar tópicos do fórum.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- MySQL
- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security

## Endpoints

### Criar Tópico

- **Endpoint:** `POST /topicos`
- **Descrição:** Cria um novo tópico.
- **Exemplo de Corpo de Requisição:**
  ```json
  {
      "titulo": "Título do Tópico",
      "mensagem": "Mensagem do Tópico",
      "estado": "Ativo",
      "autor": "Autor do Tópico",
      "curso": "Curso do Tópico"
  }
