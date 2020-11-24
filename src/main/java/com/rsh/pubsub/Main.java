package com.rsh.pubsub;

import java.util.ArrayList;
import java.util.List;

/** @author Rahil */
public class Main {

  public static void main(String[] args) {
    PubSub<String> pubSub = new PubSub<>();
    List<String> subs = new ArrayList<>();
    subs.add("sub1");
    subs.add("sub2");
    pubSub.initialize("pub1", subs);
  }
}
