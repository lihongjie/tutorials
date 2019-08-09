package com.github.lihongjie.function;

import java.util.function.DoubleSupplier;

public class DoubleSupplierTest {

    public static void main(String args[]) {

        // Create a DoubleSupplier instance
        DoubleSupplier sup = () -> Math.random();

        // Get the double value
        // Using getAsDouble() method
        System.out.println(sup.getAsDouble()); // 0.4058217033618582
    }
}
