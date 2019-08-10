package com.teracode.school.service.domain.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.*;

import com.google.common.collect.Sets;
import com.teracode.school.service.domain.type.PersonDiscriminatorType;

/**
 * @author Gonzalo Conte
 */
@Entity
@DiscriminatorValue(value = PersonDiscriminatorType.Values.TEACHER)
public class Teacher extends Employee {

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "teacher_subject", joinColumns = {@JoinColumn(name = "teacher_id")}, inverseJoinColumns = {
      @JoinColumn(name = "subject_id")})
  private Set<Subject> subjects = Sets.newHashSet();

  public Teacher() {
    //used by hibernate
  }

  public Teacher(String firstName, String lastName, BigDecimal salary) {
    super(firstName, lastName, salary);
  }

  public Set<Subject> getSubjects() {
    return subjects;
  }

  public void addSubject(Subject subject) {
    this.subjects.add(subject);
  }

  @Override
  public Long getId() {
    return super.getId();
  }
}
