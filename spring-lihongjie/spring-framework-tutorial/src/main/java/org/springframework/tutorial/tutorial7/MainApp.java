package org.springframework.tutorial.tutorial7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"org/springframework/tutorial/tutorial7/beans.xml");
		TextEditor te = (TextEditor) context.getBean("textEditor");

		te.spellCheck();
	}
}