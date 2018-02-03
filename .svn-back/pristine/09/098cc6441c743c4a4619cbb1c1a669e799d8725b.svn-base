package cn.i.rabbitmq.topic;

import static cn.i.rabbitmq.topic.RabbitPublish.EXCHANGE_NAME;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

import cn.i.rabbitmq.Define;

public class RabbitSubscribe {
	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;
	private String queueName;

	public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
		RabbitSubscribe subscribe = new RabbitSubscribe();
		subscribe.initialize();
		subscribe.send();
		subscribe.close();
	}

	private void initialize() throws IOException, TimeoutException {
		factory = new ConnectionFactory();
		factory.setHost(Define.HOST);
		connection = factory.newConnection();
		channel = connection.createChannel();
		queueName = channel.queueDeclare().getQueue();
		String routingKey = "";
		channel.queueBind(queueName, EXCHANGE_NAME, routingKey);
	}

	private void send() throws IOException, InterruptedException {
		boolean autoAck = true;
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(queueName, autoAck, consumer);
		while (true) {
			Delivery delivery = consumer.nextDelivery();
			String msg = new String(delivery.getBody());
			System.out.println("LOG MSG::" + msg);
		}
	}

	private void close() throws IOException, TimeoutException {
		channel.close();
		connection.close();
	}

}