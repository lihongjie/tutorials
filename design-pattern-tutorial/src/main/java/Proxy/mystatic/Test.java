package Proxy.mystatic;

public class Test {

    public static void main(String[] args) {

        ISinger singer = new Singer();
        ISinger proxy = new SingerProxy(singer);
        proxy.sing();
    }
}
