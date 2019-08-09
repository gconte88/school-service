package com.teracode.school.service.controller.function;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.teracode.school.service.common.dto.TeacherDTO;
import com.teracode.school.service.domain.model.Teacher;

/**
 * @author Gonzalo Conte
 */
public class TeacherFunction implements Function<Teacher, TeacherDTO> {

  public static TeacherFunction INSTANCE = new TeacherFunction();

  @Override
  public TeacherDTO apply(Teacher teacher) {
    return new TeacherDTO(teacher.getId(), teacher.getFirstName(), teacher.getLastName(), teacher.getSalary(),
        teacher.getSubjects().stream().map(SubjectFuncion.INSTANCE).collect(Collectors.toSet()));
  }
}
