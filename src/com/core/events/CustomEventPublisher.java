package com.core.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware {
   private ApplicationEventPublisher publisher;

   public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
      this.publisher = publisher;
   }

   public void call() {
      CustomEvent ce = new CustomEvent(this);
      publisher.publishEvent(ce);
   }
}