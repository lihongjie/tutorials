package Proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {

        ISinger1 singer = new Singer1();
        ISinger1 proxy = (ISinger1) Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Start");
                // process target method
                Object value = method.invoke(singer, args);
                System.out.println("End");
                return value;
            }
        });
        proxy.sing();
    }
}
