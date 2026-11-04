# Task Manager

API REST de gerenciamento de tarefas, feita em Java 17 + Spring Boot, para a disciplina de Integração DevOps (Marco 1 - CI e Conteinerização Inicial).

## Como rodar localmente

```bash
mvn spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

## Endpoints

| Método | Rota          | Descrição                  |
|--------|---------------|-----------------------------|
| GET    | /tasks        | Lista todas as tarefas      |
| GET    | /tasks/{id}   | Busca uma tarefa por id     |
| POST   | /tasks        | Cria uma nova tarefa        |
| PUT    | /tasks/{id}   | Atualiza uma tarefa         |
| DELETE | /tasks/{id}   | Remove uma tarefa           |

## Testes

```bash
mvn clean verify
```

## Docker

```bash
docker build -t task-manager .
docker run -p 8080:8080 task-manager
```

## Docker Compose (aplicação + PostgreSQL)

Para subir a aplicação junto com o banco:

```bash
cp .env.example .env
docker compose up -d --build
```

Antes de subir, abra o `.env` e coloque o usuário e a senha do banco. O arquivo `.env` não vai pro Git, e o compose não sobe sem essas variáveis.

Depois confira se os dois serviços estão saudáveis com `docker compose ps` e teste com `curl http://localhost:8080/tasks`.

Para parar tudo: `docker compose down` (com `-v` apaga também o volume do banco).

Existe também o workflow `.github/workflows/compose-test.yml`, que sobe os containers a cada PR e testa a API.

## CI

O pipeline (`.github/workflows/ci.yml`) roda o build, os testes e a validação da imagem Docker a cada Pull Request ou push na `main`.
## CD

O pipeline (`.github/workflows/cd.yml`) realiza o deploy automatizado da aplicação após a validação no fluxo de CI.

1. **Gatilhos:** Executado a cada push/merge na branch `main` ou na criação de uma nova `release`.
2. **Build e Registry:** Gera a nova imagem Docker da aplicação e publica no registro de contêineres.
3. **Deploy:** Atualiza os serviços no ambiente de destino e executa a reinicialização dos containers via `docker compose`.
4. **Validação:** Realiza a verificação de saúde (*health check*) garantindo que a nova versão está respondendo em `http://localhost:8080/health`.
