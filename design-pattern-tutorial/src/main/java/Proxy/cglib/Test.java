package Proxy.cglib;

/**
 *
 */
public class Test {

    public static void main(String[] args) {

        Singer2 singer = new Singer2();
        Singer2 proxy = (Singer2) new ProxyFactory(singer).proxyInstance();
        proxy.sing();

    }
}
