package com.github.lihongjie.function;

import java.util.function.BooleanSupplier;

public class BooleanSupplierTest {

    public static void main(String args[]) {

        // Create a BooleanSupplier instance
        BooleanSupplier sup = () -> true;

        // Get the boolean value
        // Using getAsBoolean() method
        System.out.println(sup.getAsBoolean()); // true
    }
}
