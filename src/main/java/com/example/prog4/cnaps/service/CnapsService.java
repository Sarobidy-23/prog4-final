package com.example.prog4.cnaps.service;

import com.example.prog4.cnaps.entity.Cnaps;
import com.example.prog4.cnaps.repository.CnapsRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CnapsService {
  private final CnapsRepository cnapsRepository;

  public List<Cnaps> getAll () {
    return cnapsRepository.findAll();
  }
}
