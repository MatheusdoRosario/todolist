package com.example.todolist.controller;


import com.example.todolist.entities.Tarefa;
import com.example.todolist.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping(path = "/criar")
    public Tarefa criarTarefa(@Valid Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    @DeleteMapping(path = "/excluirId/{id}")
    public void excluirTarefaPorId(@PathVariable int id){
        tarefaRepository.deleteById(id);
    }

    @GetMapping(path = "/obterTitulo/{parteTitulo}")
    public Iterable<Tarefa> obterTarefasPorTitulo(@PathVariable String parteTitulo){
        return tarefaRepository.findByTituloContainingIgnoreCase(parteTitulo);
    }

    @GetMapping(path = "/obter")
    public Iterable<Tarefa> obterTarefas(){
        return tarefaRepository.findAll();
    }

    @GetMapping(path = "/obterId/{id}")
    public Optional<Tarefa> obterTarefasPorId(@PathVariable int id){
        return tarefaRepository.findById(id);
    }

    @PutMapping(path = "/atualizar")
    public Tarefa atualizarTarefa(@Valid Tarefa tarefa){
        tarefaRepository.save(tarefa);
        return tarefa;
    }

}
