package cn.i.rabbitmq.queue;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import cn.i.rabbitmq.Define;

public class RabbitClientSend {

	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;

	public RabbitClientSend() {
	}

	public static void main(String[] argv) throws java.io.IOException, TimeoutException {
		RabbitClientSend client = new RabbitClientSend();
		try (Scanner scanner = new Scanner(System.in)) {
			String str;
			client.initialize();
			while ((str = scanner.nextLine()).length() > 0) {
				System.out.printf("Sent::%s", str);
				client.send(str);
			}
		}
		System.out.println("Send exit");
		client.close();
	}

	private void initialize() throws IOException, TimeoutException {
		factory = new ConnectionFactory();
		factory.setHost(Define.HOST);
		connection = factory.newConnection();
		channel = connection.createChannel();
	}

	private void send(String message) throws IOException {
		boolean durable = true;
		boolean exclusive = false;
		boolean autoDelete = false;
		channel.queueDeclare(Define.QUEUE_NAME, durable, exclusive, autoDelete, null);
		channel.basicPublish("", Define.QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
	}

	private void close() throws IOException, TimeoutException {
		channel.close();
		connection.close();
	}

}
