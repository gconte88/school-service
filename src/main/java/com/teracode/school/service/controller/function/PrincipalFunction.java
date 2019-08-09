package com.teracode.school.service.controller.function;

import java.util.function.Function;

import com.teracode.school.service.common.dto.PrincipalDTO;
import com.teracode.school.service.domain.model.Principal;

/**
 * @author Gonzalo Conte
 */
public class PrincipalFunction implements Function<Principal, PrincipalDTO> {

  public static PrincipalFunction INSTANCE = new PrincipalFunction();

  @Override
  public PrincipalDTO apply(Principal principal) {
    return new PrincipalDTO(principal.getId(), principal.getFirstName(), principal.getLastName(),
        principal.getSalary());
  }
}
