package com.lannstark.awssqsspringboot.controller;

import com.lannstark.awssqsspringboot.service.SqsMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainController {

  private final SqsMessageSender messageSender;

  @GetMapping("/ping")
  public String healthCheck() {
    return "pong";
  }

  @PostMapping("/message")
  public void sendMessage(@RequestBody String message) {
    messageSender.sendMessage(message);
  }

}
