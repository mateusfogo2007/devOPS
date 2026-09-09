package com.taskmanager.service;

import com.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// A anotação @Service diz ao Spring que esta é a classe de regras de negócio
@Service
public class TaskService {

    // Lista em memória para guardar as tarefas (já que não há banco de dados ainda)
    private List<Task> tasks = new ArrayList<>();
    
    // Um contador simples para gerar os IDs das tarefas automaticamente
    private Long nextId = 1L;

    // Método para CRIAR uma tarefa
    public Task create(Task task) {
        task.setId(nextId); // Atribui o ID atual
        nextId++; // Prepara o próximo ID
        tasks.add(task);
        return task;
    }

    // Método para LISTAR TODAS as tarefas
    public List<Task> findAll() {
        return tasks;
    }

    // Método para BUSCAR uma tarefa por ID
    public Task findById(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null; // Retorna nulo se não encontrar
    }

    // Método para ATUALIZAR uma tarefa
    public Task update(Long id, Task updatedTask) {
        Task taskExistente = findById(id);
        if (taskExistente != null) {
            taskExistente.setTitle(updatedTask.getTitle());
            taskExistente.setDone(updatedTask.isDone());
            return taskExistente;
        }
        return null;
    }

    // Método para REMOVER uma tarefa
    public boolean delete(Long id) {
        Task taskExistente = findById(id);
        if (taskExistente != null) {
            tasks.remove(taskExistente);
            return true;
        }
        return false;
    }
}
