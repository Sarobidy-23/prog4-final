package com.example.prog4.controller.view;

import com.example.prog4.config.CompanyConf;
import com.example.prog4.controller.mapper.EmployeeMapper;
import com.example.prog4.model.Employee;
import com.example.prog4.service.EmployeeService;
import com.itextpdf.html2pdf.HtmlConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.OutputStream;

@Controller
@AllArgsConstructor
public class PDFControllerView {
  private final TemplateEngine templateEngine;
  private final EmployeeService employeeService;
  private final EmployeeMapper employeeMapper;

  @GetMapping("/employee/sheet/{eId}")
  @ResponseBody
  public void generatePdf(OutputStream outputStream, @PathVariable String eId) throws Exception {
    Employee employee = employeeMapper.toView(employeeService.getOne(eId));
    CompanyConf company = new CompanyConf();
    Context context = new Context();
    context.setVariable("employee", employee);
    context.setVariable("company", company);
    String htmlContent = templateEngine.process("render", context);
    HtmlConverter.convertToPdf(htmlContent, outputStream);
  }
}