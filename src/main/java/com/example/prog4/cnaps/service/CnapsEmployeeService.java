package com.example.prog4.cnaps.service;

import com.example.prog4.cnaps.entity.CnapsEmployee;
import com.example.prog4.cnaps.repository.CnapsEmployeeRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CnapsService {
  private final CnapsEmployeeRepository cnapsRepository;

  public List<CnapsEmployee> getAll () {
    return cnapsRepository.findAll();
  }
}
