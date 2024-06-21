package com.rsh.pubsub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** @author Rahil */
public class PubSub {

  public static void main(String[] args) {
    Queue<Message<String>> queue = new InMemoryQueue<>();

    Publisher<String> publisher = new PublisherImpl<>(queue);

    List<Subscriber<String>> subscribers = new ArrayList<>();
    subscribers.add(new SubscriberImpl<>("s1", queue));
    subscribers.add(new SubscriberImpl<>("s2", queue));

    ExecutorService executorService = Executors.newFixedThreadPool(subscribers.size() + 1);

    executorService.submit(() -> startPublisher(publisher));

    for (Subscriber<String> subscriber : subscribers) {
      executorService.submit(() -> startSubscriber(subscriber));
    }
    executorService.shutdown();
  }

  private static void startPublisher(Publisher<String> publisher) {
    int i = 0;
    while (true) {
      publisher.publish(new Message<>("" + i++));
    }
  }

  private static void startSubscriber(Subscriber<String> subscriber) {
    while (true) {
      Message<String> message = subscriber.poll();
      if (message != null) {
        System.out.println(subscriber.getName() + " received: " + message.getBody());
      }
    }
  }
}
