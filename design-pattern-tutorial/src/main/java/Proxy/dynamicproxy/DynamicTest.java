package Proxy.dynamicproxy;


import Proxy.demo.Hello;
import Proxy.demo.IHello;

public class DynamicTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DynamicProxy proxy = new DynamicProxy();
		IHello hello = (IHello) proxy.bind(new Hello());
		hello.sayHello1();
		hello.sayHello2();
		hello.sayHello3();
	}

}
