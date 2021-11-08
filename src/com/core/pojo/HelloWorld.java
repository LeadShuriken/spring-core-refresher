package com.core.pojo;

import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {
   private String message1;
   private String message2;
   private Integer id;

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getId() {
      return id;
   }

   @Required
   public void setMessage1(String message) {
      this.message1 = message;
   }

   @Required
   public void setMessage2(String message) {
      this.message2 = message;
   }

   @Override
   public String toString() {
      return "HelloWorld [id=" + id + ", message1=" + message1 + ", message2=" + message2 + "]";
   }

   public String getMessage1() {
      System.out.println("World Message1 : " + message1);
      return message1;
   }

   public String getMessage2() {
      System.out.println("World Message2 : " + message2);
      return message2;
   }

   public void init() {
      System.out.println("Hello World is going through init");
   }

   public void cleanup() {
      System.out.println("Hello World will cleanup now.");
   }

   public void printThrowException() {
      System.out.println("Exception raised");
      throw new IllegalArgumentException();
   }
}