package com.teracode.school.service.controller.function;

import java.util.function.Function;

import com.teracode.school.service.common.dto.SubjectDTO;
import com.teracode.school.service.domain.model.Subject;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author Gonzalo Conte
 */
public class SubjectFuncion implements Function<Subject, SubjectDTO> {

  public static SubjectFuncion INSTANCE = new SubjectFuncion();

  @Override
  public SubjectDTO apply(@Nullable Subject subject) {
    return new SubjectDTO(subject.getId(), subject.getName());
  }
}
