package com.lannstark.awssqsspringboot.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.lannstark.awssqsspringboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsMessageService {

  private final QueueMessagingTemplate queueMessagingTemplate;

  @Autowired
  public SqsMessageService(AmazonSQS amazonSqs) {
    this.queueMessagingTemplate = new QueueMessagingTemplate((AmazonSQSAsync) amazonSqs);
  }

  public void getMessage() {
    Person person = queueMessagingTemplate.receiveAndConvert("sqs-study", Person.class);
    System.out.println("SQS 로부터 받은 메시지 : " + person);
  }

  public void sendMessage(String name) {
    queueMessagingTemplate.convertAndSend("sqs-study", new Person(name, 20));
  }

}
