package com.teracode.school.service.domain.model;

import javax.persistence.*;

import com.teracode.school.service.domain.type.PersonDiscriminatorType;

/**
 * @author Gonzalo Conte
 */
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",
                     discriminatorType = DiscriminatorType.STRING)
public abstract class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "type", nullable = false, insertable = false, updatable = false)
  @Enumerated(EnumType.STRING)
  public PersonDiscriminatorType type;

  public Person() {
    //used by hibernate
  }

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Long getId() {
    return id;
  }
}
