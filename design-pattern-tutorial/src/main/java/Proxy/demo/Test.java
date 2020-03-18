package Proxy.demo;

public class Test {

    public static void main(String[] args) {

        IHello hello = new ProxyHello(new Hello());
        hello.sayHello1();
        hello.sayHello2();
        hello.sayHello3();
    }
}
