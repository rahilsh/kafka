package com.rsh.pubsub;

/** @author Rahil */
public interface Queue<T> {

  void put(T message);

  T poll();
}
