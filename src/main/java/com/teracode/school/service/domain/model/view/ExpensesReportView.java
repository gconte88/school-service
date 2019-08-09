package com.teracode.school.service.domain.model.view;

import java.math.BigDecimal;

/**
 * @author Gonzalo Conte
 */
public interface ExpensesReportView {

  BigDecimal getTeachersSalary();

  BigDecimal getJanitorsSalary();

  BigDecimal getPrincipalSalary();

  BigDecimal getMinimumSalary();

  BigDecimal getMaximumSalary();

  BigDecimal getAverageSalary();

  BigDecimal getTotalExpenses();
}
