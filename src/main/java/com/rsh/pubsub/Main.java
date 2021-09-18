package com.rsh.pubsub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/** @author Rahil */
public class Main {

  public static void main(String[] args) {
    PubSub<String> pubSub = new PubSub<>();
    List<Subscriber<String>> subs = new ArrayList<>();
    ArrayBlockingQueue<Message<String>> queue = new ArrayBlockingQueue<>(10240);
    subs.add(new Subscriber<>("sub1", queue));
    subs.add(new Subscriber<>("sub2", queue));
    Publisher<String> publisher = new Publisher<>("pub1", queue);
    pubSub.initialize(publisher, subs);
  }
}
