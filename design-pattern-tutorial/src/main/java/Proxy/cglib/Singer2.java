package Proxy.cglib;

import Proxy.jdk.ISinger1;

public class Singer2 implements ISinger1 {

    @Override
    public void sing() {
        System.out.println("lalalalala");
    }
}
