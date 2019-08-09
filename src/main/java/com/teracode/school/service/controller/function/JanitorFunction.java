package com.teracode.school.service.controller.function;

import java.util.function.Function;

import com.teracode.school.service.common.dto.JanitorDTO;
import com.teracode.school.service.domain.model.Janitor;

/**
 * @author Gonzalo Conte
 */
public class JanitorFunction implements Function<Janitor, JanitorDTO> {

  public static JanitorFunction INSTANCE = new JanitorFunction();

  @Override
  public JanitorDTO apply(Janitor janitor) {
    return new JanitorDTO(janitor.getId(), janitor.getFirstName(), janitor.getLastName(), janitor.getSalary(),
        janitor.getWorkingArea().name());
  }
}
