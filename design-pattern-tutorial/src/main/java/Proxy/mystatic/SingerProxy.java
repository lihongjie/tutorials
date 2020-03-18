package Proxy.mystatic;

public class SingerProxy implements ISinger {

    private ISinger target;

    public SingerProxy(ISinger singer) {
        this.target = singer;
    }


    @Override
    public void sing() {
        System.out.println("Start");
        target.sing();
        System.out.println("End");
    }
}
