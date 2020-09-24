package com.bela.demo.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@NoArgsConstructor
public class Assignee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long assId;
  private String name;
  private String email;
  @OneToMany (mappedBy = "assignee")
  private List<Todo> todos;

  public Assignee(String name, String email) {
    this.name = name;
    this.email = email;
  }
}