package com.exemplo.taskmanager.model; // Ajuste para o pacote real do seu projeto

public class Task {
    // Atributos da tarefa, protegidos (private)
    private Long id;
    private String title;
    private boolean done;

    // Construtor vazio (necessário para o Spring Boot)
    public Task() {
    }

    // Getters e Setters (métodos para acessar e modificar os dados de forma segura)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}