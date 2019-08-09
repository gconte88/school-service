package com.teracode.school.service.domain.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.teracode.school.service.domain.type.PersonDiscriminatorType;

/**
 * @author Gonzalo Conte
 */
@Entity
//@Table(name = "principal")
@DiscriminatorValue(value= PersonDiscriminatorType.Values.PRINCIPAL)
public class Principal extends Employee {

  public Principal() {
  }

  public Principal(String firstName, String lastName, BigDecimal salary) {
    super(firstName, lastName, salary);
  }

  @Override
  public Long getId() {
    return super.getId();
  }
}
