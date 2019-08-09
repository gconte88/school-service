package com.teracode.school.service.controller.function;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.teracode.school.service.common.dto.StudentDTO;
import com.teracode.school.service.domain.model.Student;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author Gonzalo Conte
 */
public class StudentFunction implements Function<Student, StudentDTO> {

  public static StudentFunction INSTANCE = new StudentFunction();

  @Override
  public StudentDTO apply(@Nullable Student student) {
    return new StudentDTO(student.getId(), student.getFirstName(), student.getLastName(),
        student.getSubjects().stream().map(SubjectFuncion.INSTANCE).collect(Collectors.toSet()),
        student.getBirthDate());
  }
}
