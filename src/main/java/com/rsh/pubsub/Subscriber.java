package com.rsh.pubsub;

import java.util.concurrent.BlockingQueue;

/** @author Rahil */
public class Subscriber<T> implements Runnable {

  private final BlockingQueue<Message<T>> queue;
  private final String name;

  public Subscriber(String name, BlockingQueue<Message<T>> queue) {
    this.name = name;
    this.queue = queue;
  }

  @Override
  public void run() {
    while (true) {
      if (queue.size() > 1) {
        System.out.println(name + " Subscribing: " + queue.poll().getBody());
        try {
          Thread.sleep(300);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
