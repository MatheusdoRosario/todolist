package com.example.todolist.repository;

import com.example.todolist.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    public Iterable<Tarefa> findByTituloContainingIgnoreCase(String parteTitulo);
}
