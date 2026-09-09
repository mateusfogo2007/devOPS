package com.taskmanager.service;

import com.taskmanager.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        // Nova instância a cada teste, para não vazar estado entre os testes
        taskService = new TaskService();
    }

    @Test
    void deveCriarUmaTarefaComIdGeradoAutomaticamente() {
        Task novaTask = new Task();
        novaTask.setTitle("Estudar Spring Boot");
        novaTask.setDone(false);

        Task criada = taskService.create(novaTask);

        assertNotNull(criada.getId());
        assertEquals("Estudar Spring Boot", criada.getTitle());
        assertFalse(criada.isDone());
    }

    @Test
    void deveListarTodasAsTarefasCriadas() {
        Task t1 = new Task();
        t1.setTitle("Tarefa 1");
        taskService.create(t1);

        Task t2 = new Task();
        t2.setTitle("Tarefa 2");
        taskService.create(t2);

        List<Task> todas = taskService.findAll();

        assertEquals(2, todas.size());
    }

    @Test
    void deveBuscarTarefaPorIdExistente() {
        Task t1 = new Task();
        t1.setTitle("Comprar leite");
        Task criada = taskService.create(t1);

        Task encontrada = taskService.findById(criada.getId());

        assertNotNull(encontrada);
        assertEquals("Comprar leite", encontrada.getTitle());
    }

    @Test
    void deveRetornarNuloAoBuscarTarefaPorIdInexistente() {
        Task encontrada = taskService.findById(999L);

        assertNull(encontrada);
    }

    @Test
    void deveAtualizarUmaTarefaExistente() {
        Task original = new Task();
        original.setTitle("Titulo antigo");
        original.setDone(false);
        Task criada = taskService.create(original);

        Task dadosAtualizados = new Task();
        dadosAtualizados.setTitle("Titulo novo");
        dadosAtualizados.setDone(true);

        Task atualizada = taskService.update(criada.getId(), dadosAtualizados);

        assertNotNull(atualizada);
        assertEquals("Titulo novo", atualizada.getTitle());
        assertTrue(atualizada.isDone());
    }

    @Test
    void deveRetornarNuloAoAtualizarTarefaInexistente() {
        Task dadosAtualizados = new Task();
        dadosAtualizados.setTitle("Nao importa");

        Task resultado = taskService.update(999L, dadosAtualizados);

        assertNull(resultado);
    }

    @Test
    void deveRemoverUmaTarefaExistente() {
        Task t1 = new Task();
        t1.setTitle("Tarefa a remover");
        Task criada = taskService.create(t1);

        boolean removida = taskService.delete(criada.getId());

        assertTrue(removida);
        assertNull(taskService.findById(criada.getId()));
    }

    @Test
    void deveRetornarFalseAoRemoverTarefaInexistente() {
        boolean removida = taskService.delete(999L);

        assertFalse(removida);
    }
}
