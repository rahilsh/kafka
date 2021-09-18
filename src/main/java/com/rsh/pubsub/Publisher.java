package com.rsh.pubsub;

/** @author Rahil */
public interface Publisher<T> {
  void publish(Message<T> message);
}
