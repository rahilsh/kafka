package com.rsh.pubsub;

import java.util.List;

/** @author Rahil */
public class PubSub<T> {

  public void initialize(Publisher<T> publisher, List<Subscriber<T>> subscribers) {
    for (Subscriber<T> subscriber : subscribers) {
      new Thread(subscriber).start();
    }
    new Thread(publisher).start();
  }
}
