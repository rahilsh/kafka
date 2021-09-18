package com.rsh.pubsub;

/** @author Rahil */
public interface Subscriber<T> {

  Message<T> poll();
  String getName();
}
