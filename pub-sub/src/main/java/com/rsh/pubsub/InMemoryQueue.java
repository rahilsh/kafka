package com.rsh.pubsub;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/** @author Rahil */
public class InMemoryQueue<T> implements Queue<Message<T>> {

  private final BlockingQueue<Message<T>> queue = new ArrayBlockingQueue<>(1024);

  @Override
  public void put(Message<T> message) {
    try {
      queue.put(message);
      System.out.println("Published: " + message.getBody());
    } catch (InterruptedException e) {
      throw new RuntimeException("Error while publishing: " + e.getMessage());
    }
  }

  @Override
  public Message<T> poll() {
    return queue.poll();
  }
}
