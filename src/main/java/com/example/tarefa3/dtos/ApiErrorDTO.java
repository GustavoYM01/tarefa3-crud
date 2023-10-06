package com.example.tarefa3.dtos;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrorDTO {
  @Getter
  private List<String> errors;

  public ApiErrorDTO(String msg) {
    this.errors = Arrays.asList(msg);
  }
}
