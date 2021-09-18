package com.rsh.pubsub;

import java.util.concurrent.BlockingQueue;

/** @author Rahil */
public class Publisher<T> implements Runnable {

  private final BlockingQueue<Message<T>> queue;
  private final String name;

  public Publisher(String name, BlockingQueue<Message<T>> queue) {
    this.name = name;
    this.queue = queue;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      Message<String> message = new Message<>("Message:" + i);
      System.out.println(name + " Publishing: " + message.getBody());
      queue.add((Message<T>) message);
    }
  }
}
