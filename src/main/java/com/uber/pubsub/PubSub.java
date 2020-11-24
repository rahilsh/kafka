package com.uber.pubsub;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/** @author Rahil */
public class PubSub<T> {

  public void initialize(String publisher, List<String> subscribers) {
    BlockingQueue<Message<T>> queue = new ArrayBlockingQueue<>(1024);
    for (String subscriber : subscribers) {
      new Thread(new Subscriber<>(subscriber, queue)).start();
    }
    new Thread(new Publisher<>(publisher, queue)).start();
  }
}
