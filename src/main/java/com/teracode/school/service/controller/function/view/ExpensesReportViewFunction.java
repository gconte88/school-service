package com.teracode.school.service.controller.function.view;

import java.util.function.Function;

import com.teracode.school.service.common.dto.view.ExpensesReportViewDTO;
import com.teracode.school.service.core.model.ExpensesReportViewModel;

/**
 * @author Gonzalo Conte
 */
public class ExpensesReportViewFunction implements Function<ExpensesReportViewModel, ExpensesReportViewDTO> {

  public static ExpensesReportViewFunction INSTANCE = new ExpensesReportViewFunction();

  @Override
  public ExpensesReportViewDTO apply(ExpensesReportViewModel expensesReportViewModel) {
    return new ExpensesReportViewDTO(expensesReportViewModel.getPrincipalSalary(), expensesReportViewModel.getTeachersSalary(),
        expensesReportViewModel.getJanitorsSalary(), expensesReportViewModel.getTotalExpenses(), expensesReportViewModel.getAverageSalary(),
        expensesReportViewModel.getMaximumSalary(), expensesReportViewModel.getMinimumSalary());
  }
}
