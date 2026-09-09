package com.taskmanager.service;

import com.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();
    
    private Long nextId = 1L;

    public Task create(Task task) {
        task.setId(nextId); // Atribui o ID atual
        nextId++; // Prepara o próximo ID
        tasks.add(task);
        return task;
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null; 
    }

    public Task update(Long id, Task updatedTask) {
        Task taskExistente = findById(id);
        if (taskExistente != null) {
            taskExistente.setTitle(updatedTask.getTitle());
            taskExistente.setDone(updatedTask.isDone());
            return taskExistente;
        }
        return null;
    }

    public boolean delete(Long id) {
        Task taskExistente = findById(id);
        if (taskExistente != null) {
            tasks.remove(taskExistente);
            return true;
        }
        return false;
    }
}
