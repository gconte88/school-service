package com.teracode.school.service.domain.model;

import javax.persistence.*;

/**
 * @author Gonzalo Conte
 */
@Entity
@Table(name = "subject")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", unique = true, updatable = false)
  private String name;

  public Subject() {
    //used by hibernate
  }

  public Subject(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Subject))
      return false;

    Subject subject = (Subject) o;

    return getName() != null ? getName().equals(subject.getName()) : subject.getName() == null;
  }

  @Override
  public int hashCode() {
    return getName() != null ? getName().hashCode() : 0;
  }
}
