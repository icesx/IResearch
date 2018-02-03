package cn.i.rabbitmq.topic;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
//import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import cn.i.rabbitmq.Define;

public class RabbitPublish {
	public final static String EXCHANGE_NAME = "logs";
	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;

	public static void main(String[] args) throws IOException, TimeoutException {
		RabbitPublish subscribe = new RabbitPublish();
		subscribe.initialize();
		subscribe.send();
		subscribe.close();

	}

	private void initialize() throws IOException, TimeoutException {
		factory = new ConnectionFactory();
		factory.setHost(Define.HOST);
		connection = factory.newConnection();
		channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

	}

	private void send() throws IOException {
		Scanner scanner = new Scanner(System.in);
		String input;
		while ((input = scanner.nextLine()) != null) {
			String routingKey = "";
			AMQP.BasicProperties props = null;
			channel.basicPublish(EXCHANGE_NAME, routingKey, props, input.getBytes());
			System.out.printf("Message Sent %s", input);
		}
		scanner.close();
	}

	private void close() throws IOException, TimeoutException {
		channel.close();
		connection.close();
	}

}
