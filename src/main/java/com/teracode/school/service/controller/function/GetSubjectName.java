package com.teracode.school.service.controller.function;

import java.util.function.Function;

import com.teracode.school.service.domain.model.Subject;

/**
 * @author gon
 */
public class GetSubjectName implements Function<Subject, String> {

  public static GetSubjectName INSTANCE = new GetSubjectName();
  @Override
  public String apply(Subject subject) {
    return subject.getName();
  }
}
