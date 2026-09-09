# Task Manager

API REST de gerenciamento de tarefas, desenvolvida em Java 17 + Spring Boot, para a disciplina de Integração DevOps (Marco 1 — CI e Conteinerização Inicial).

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

## CI

O pipeline (`.github/workflows/ci.yml`) roda automaticamente o build, os testes e a validação da imagem Docker a cada Pull Request ou push na `main`.
