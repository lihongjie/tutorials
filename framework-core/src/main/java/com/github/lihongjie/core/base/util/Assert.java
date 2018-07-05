package com.github.lihongjie.core.base.util;

import java.util.Collection;
import java.util.Map;

public class Assert {

    private static final String CANNOT_BE_EMPTY = " cannot be empty";

    private Assert() {}

    public static void notNull(String argumentName, Object argumentObject) {

        if (argumentObject == null) {
            throw new IllegalArgumentException(argumentName + "cannot be null");
        }
    }

    public static void notNull(Object... arguments) {
        for (int i = 0; i < arguments.length;) {
            notNull((String) arguments[i++], arguments[i++]);
        }
    }

    public static <T> void notEmpty(String argumentName, T[] argumentObject) {
        notNull(argumentName, argumentObject);
        if (argumentObject.length == 0) {
            throw new IllegalArgumentException(argumentName + CANNOT_BE_EMPTY);
        }
    }


    public static <T extends Collection<?>> void notEmpty(String argumentName, T argumentObject) {
        notNull(argumentName, argumentObject);
        if (argumentObject.isEmpty()) {
            throw new IllegalArgumentException(argumentName + CANNOT_BE_EMPTY);
        }
    }

    public static <T extends Map<?, ?>> void notEmpty(String argumentName, T argumentObject) {
        notNull(argumentName, argumentObject);
        if (argumentObject.size() == 0) {
            throw new IllegalArgumentException(argumentName + CANNOT_BE_EMPTY);
        }
    }
}
