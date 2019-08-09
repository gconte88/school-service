package com.teracode.school.service.domain.repository;

import com.teracode.school.service.domain.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gonzalo Conte
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
