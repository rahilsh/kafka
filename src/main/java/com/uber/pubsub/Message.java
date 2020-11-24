package com.uber.pubsub;

/** @author Rahil */
public class Message<T> {

  public Message(Object body) {
    this.body = (T) body;
  }

  public T getBody() {
    return body;
  }

  private T body;
}
