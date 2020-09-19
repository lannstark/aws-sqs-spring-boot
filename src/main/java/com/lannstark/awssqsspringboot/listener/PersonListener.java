package com.lannstark.awssqsspringboot.listener;

import com.lannstark.awssqsspringboot.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PersonListener {

  @SqsListener(value = "sqs-study", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
  public void listen(@Payload Person person, Acknowledgment ack) {
    log.info("{}", person);
    ack.acknowledge();
  }

}
