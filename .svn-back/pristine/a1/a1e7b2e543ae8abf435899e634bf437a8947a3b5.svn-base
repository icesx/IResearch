package cn.i.research.kafka.base;

import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Pick whether we want to run as producer or consumer. This lets us have a
 * single executable as a build target.
 */
public class Run {
	private static Logger logger = Logger.getLogger(Run.class);

	public static void main(final String[] args) throws IOException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Producer.main(args);
				} catch (IOException e) {
					logger.error(e,e);
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				try {
					Consumer.main(args);
				} catch (IOException e) {
					logger.error(e, e);
				}
			}
		}).start();
	}
}
