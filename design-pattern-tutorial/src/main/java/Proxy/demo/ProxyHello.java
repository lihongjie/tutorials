package Proxy.demo;

public class ProxyHello implements IHello {

    private IHello hello;

    public ProxyHello(IHello hello) {
        this.hello = hello;
    }

    public void validateUser() {
        System.out.println("validate User....");
    }

    @Override
    public void sayHello1() {
        validateUser();
        hello.sayHello1();
    }

    @Override
    public void sayHello2() {
        validateUser();
        hello.sayHello2();
    }

    @Override
    public void sayHello3() {
        validateUser();
        hello.sayHello3();
    }


}
