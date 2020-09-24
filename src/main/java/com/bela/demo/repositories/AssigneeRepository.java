package com.bela.demo.repositories;

import com.bela.demo.models.Assignee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepository extends CrudRepository <Assignee, Long> {
  List<Assignee> findAll ();

  Assignee findById(long id);

  Assignee findByEmail(String email);

  Assignee findByName (String assigneename);

}
