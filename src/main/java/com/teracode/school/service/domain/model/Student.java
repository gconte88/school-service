package com.teracode.school.service.domain.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.teracode.school.service.domain.type.PersonDiscriminatorType;

/**
 * @author Gonzalo Conte
 */
@Entity
@DiscriminatorValue(value= PersonDiscriminatorType.Values.STUDENT)
public class Student extends Person {

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "student_subject", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {
      @JoinColumn(name = "subject_id")})
  private Set<Subject> subjects = new HashSet<>();

  @Column(name = "birth_date")
  private Date birthDate;

  public Student() {
    //used by hibernate
  }

  public Student(String firstName, String lastName, Date birthDate) {
    super(firstName, lastName);
    this.birthDate = birthDate;
  }

  public Set<Subject> getSubjects() {
    return subjects;
  }

  public void addSubject(Subject subject) {
    this.subjects.add(subject);
  }

  public Date getBirthDate() {
    return birthDate;
  }

  @Override
  public Long getId() {
    return super.getId();
  }
}
