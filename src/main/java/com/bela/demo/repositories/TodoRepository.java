package com.bela.demo.repositories;

import com.bela.demo.models.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {
  List<Todo> findAll();

  Todo findById (int id);
}
