package com.rsh.pubsub;

/** @author Rahil */
public class SubscriberImpl<T> implements Subscriber<T> {

  private final String name;
  private final Queue<Message<T>> queue;

  public SubscriberImpl(String name, Queue<Message<T>> queue) {
    this.queue = queue;
    this.name = name;
  }

  @Override
  public Message<T> poll() {
    return queue.poll();
  }

  @Override
  public String getName() {
    return name;
  }
}
