package com.rsh.pubsub;

/** @author Rahil */
public class Message<T> {

  public Message(T body) {
    this.body = body;
  }

  public T getBody() {
    return body;
  }

  private final T body;
}
