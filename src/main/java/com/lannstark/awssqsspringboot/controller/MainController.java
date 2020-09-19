package com.lannstark.awssqsspringboot.controller;

import com.lannstark.awssqsspringboot.service.SqsMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainController {

  private final SqsMessageService messageService;

  @GetMapping("/ping")
  public String healthCheck() {
    return "pong";
  }

  @GetMapping("/message")
  public void getMessage() {
    messageService.getMessage();
  }

  @PostMapping("/message")
  public void sendMessage(@RequestBody String name) {
    messageService.sendMessage(name);
  }

}
