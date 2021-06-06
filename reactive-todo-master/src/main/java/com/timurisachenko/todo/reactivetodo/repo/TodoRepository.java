package com.timurisachenko.todo.reactivetodo.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.timurisachenko.todo.reactivetodo.model.Todo;


public interface TodoRepository extends ReactiveCrudRepository<Todo, Long> {

}
