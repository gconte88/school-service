package com.teracode.school.service.common.dto;

import java.math.BigDecimal;

/**
 * @author Gonzalo Conte
 */
public class PrincipalDTO extends EmployeeDTO {

  private static final long serialVersionUID = -3113363792795958811L;

  public PrincipalDTO(long id, String firstName, String lastName, BigDecimal salary) {
    super(id, firstName, lastName, salary);
  }
}
