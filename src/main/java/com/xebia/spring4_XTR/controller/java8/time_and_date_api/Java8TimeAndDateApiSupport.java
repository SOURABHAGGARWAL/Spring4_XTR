package com.xebia.spring4_XTR.controller.java8.time_and_date_api;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Java8timeanddateapisupport")
public class Java8TimeAndDateApiSupport {

  @RequestMapping("/date/{localDate}")
  public String get(@DateTimeFormat(iso = ISO.DATE) LocalDate localDate)
  {
    return localDate.toString();
  }
}
