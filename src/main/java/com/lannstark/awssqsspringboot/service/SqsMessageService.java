package com.lannstark.awssqsspringboot.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.lannstark.awssqsspringboot.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SqsMessageService {

  private final QueueMessagingTemplate queueMessagingTemplate;

  @Autowired
  public SqsMessageService(AmazonSQS amazonSqs) {
    this.queueMessagingTemplate = new QueueMessagingTemplate((AmazonSQSAsync) amazonSqs);
  }

  public void getMessage() {
    Person person = queueMessagingTemplate.receiveAndConvert("sqs-study", Person.class);
    System.out.println("SQS로부터 받은 메시지 : " + person);
  }

  public void sendMessage(Person person) {
    log.info("SQS에 Person을 전달합니다 : " + person);
    queueMessagingTemplate.convertAndSend("sqs-study", person);
  }

}
