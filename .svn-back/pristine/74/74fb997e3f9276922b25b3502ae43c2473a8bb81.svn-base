package cn.i.rabbitmq.queue;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import cn.i.rabbitmq.Define;

public class RabbitClientReceive {
	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;

	public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
		RabbitClientReceive receiver = new RabbitClientReceive();
		receiver.initialize();
		receiver.receive();
		receiver.close();
	}

	public void initialize() throws IOException, TimeoutException {
		factory = new ConnectionFactory();
		factory.setHost(Define.HOST);
		connection = factory.newConnection();
		channel = connection.createChannel();
		int prefetchCount = 1;
		channel.basicQos(prefetchCount);

	}

	public void receive() throws IOException, InterruptedException {
		boolean durable = true;
		channel.queueDeclare(Define.QUEUE_NAME, durable, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		QueueingConsumer consumer = new QueueingConsumer(channel);
		boolean autoAck = false;
		channel.basicConsume(Define.QUEUE_NAME, autoAck, consumer);
		Random random = new Random();

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			boolean multiple = false;
			boolean requeue = true;
			System.out.println(" [x] Received '" + message + "'");
			doWork(message);
			switch (random.nextInt(2)) {
			case 0:
				channel.basicNack(delivery.getEnvelope().getDeliveryTag(), multiple, requeue);
				System.out.println(" [x] Rejected '" + message + "'");
				break;
			case 1:
				channel.basicAck(delivery.getEnvelope().getDeliveryTag(), multiple);
				System.out.println(" [x] Processed '" + message + "'");
				break;
			case 2:
				break;

			}

		}
	}

	public void doWork(String message) {
		try {
			for (char c : message.toCharArray()) {
				if (c == '.') {
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException ex) {
		}
	}

	public void close() throws IOException, TimeoutException {
		channel.close();
		connection.close();
	}
}
