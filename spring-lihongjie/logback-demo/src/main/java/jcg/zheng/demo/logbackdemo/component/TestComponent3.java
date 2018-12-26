package jcg.zheng.demo.logbackdemo.component;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Level;

@Component
public class TestComponent3 extends DemoLog{

	@PostConstruct
	public void setup() {
		ch.qos.logback.classic.Logger logbackLogger = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger(TestComponent3.class);
		logbackLogger.setLevel(Level.ERROR);
		DemoLog.logStatements(logbackLogger, "-inside TestComponent3.setup() ");
	}
}
