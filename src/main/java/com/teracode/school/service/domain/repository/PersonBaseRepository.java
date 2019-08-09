package com.teracode.school.service.domain.repository;

import com.teracode.school.service.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Gonzalo Conte
 */
@NoRepositoryBean
public interface PersonBaseRepository<T extends Person> extends JpaRepository<T, Long> {

}
