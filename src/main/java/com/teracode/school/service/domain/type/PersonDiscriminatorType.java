package com.teracode.school.service.domain.type;

/**
 * @author Gonzalo Conte
 */
public enum PersonDiscriminatorType {

  JANITOR(Values.JANITOR),
  PRINCIPAL(Values.PRINCIPAL),
  STUDENT(Values.STUDENT),
  TEACHER(Values.TEACHER),
  EMPLOYEE(Values.EMPLOYEE);

  private PersonDiscriminatorType (String val) {
    if (!this.name().equals(val)) {
      throw new IllegalArgumentException("school.service.error.person.discriminator.type.not.found");
    }
  }

  public static class Values {
    public static final String JANITOR= "JANITOR";
    public static final String PRINCIPAL= "PRINCIPAL";
    public static final String STUDENT= "STUDENT";
    public static final String TEACHER= "TEACHER";
    public static final String EMPLOYEE= "EMPLOYEE";
  }
}
