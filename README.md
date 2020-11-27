# interview

Notification with Kafka

This branch will send notification through Kafka Producer and Consumer. Please download the latest version of Kafka here:
https://kafka.apache.org/downloads

Start Zookeeper:
bin/zookeeper-server-start.sh config/zookeeper.properties

Start Kafka Server:
bin/kafka-server-start.sh config/server.properties

Create Kafka Topic
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topic

Publish to Kafka Topic
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic --from-beginning