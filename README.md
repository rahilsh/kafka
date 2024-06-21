# Kafka

## kafka commands
```
./kafka-console-consumer.sh --zookeeper mqueue.localzoho.com:2181 --topic ZCrmMotivator
./kafka-console-consumer.sh --zookeeper localhost:2181 --topic ZCrmMotivator
 ```
Check partitions
 ```
sh kafka-topics.sh --describe --zookeeper localhost:2181 --topic ZCrmMotivator
```
 
Check offsets
 ```
./kafka-consumer-offset-checker.sh --group <counsumer_group> --topic <topic> --zookeeper localhost:2181
```
 
Login to shell to check the offsets
 ```
sh zookeeper-shell.sh localhost:2181
ls /consumers
ls /consumers/<counsumer_group>
get /consumers/<counsumer_group>/offsets/<topic>/0
```
  
Clear Kafka logs
 ```
rm -rf /tmp/kafka-logs/
```

## pub-sub app

Simple publisher-subscriber app with in memory implementation

Features
1. Publisher and subscriber are decoupled
2. Generic interface for initializing publishers and subscribers

Entities
1. Publisher
2. Subscriber
3. Queue
4. Message
