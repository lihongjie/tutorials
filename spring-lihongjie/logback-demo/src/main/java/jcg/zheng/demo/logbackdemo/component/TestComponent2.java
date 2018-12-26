package jcg.zheng.demo.logbackdemo.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestComponent2 extends DemoLog{
	private static final Logger lOG = LoggerFactory.getLogger(TestComponent2.class);


	@PostConstruct
	public void setup() {
		logStatements(lOG,"-inside TestComponent2.setup() ");
	}

	@PreDestroy
	public void clean() {
		logStatements(lOG,"-inside TestComponent2.clean() ");
	}
}
