package jcg.zheng.demo.logbackdemo.component;

import org.slf4j.Logger;

public abstract class DemoLog {
	
	public static void logStatements(Logger logger, String message) {
		logger.trace("log a trace message {}", message);
		logger.debug("log a debug message {}", message);
		logger.info("log a info message {}", message);
		logger.warn("log a warn message {}", message);
		logger.error("log an error message {}", message);
	}
}
