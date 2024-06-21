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
