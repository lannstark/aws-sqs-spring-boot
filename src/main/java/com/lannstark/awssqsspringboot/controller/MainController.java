package com.lannstark.awssqsspringboot.controller;

import com.lannstark.awssqsspringboot.model.Person;
import com.lannstark.awssqsspringboot.service.SqsMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MainController {

  private final SqsMessageService messageService;

  @GetMapping("/ping")
  public String healthCheck() {
    log.info("pong");
    return "pong";
  }

  @GetMapping("/message")
  public void getMessage() {
    messageService.getMessage();
  }

  @PostMapping("/message")
  public void sendMessage(@RequestBody Person person) {
    messageService.sendMessage(person);
  }

}
