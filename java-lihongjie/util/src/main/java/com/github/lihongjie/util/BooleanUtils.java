package com.github.lihongjie.util;

/**
 *
 */
public class BooleanUtils {
    
    /** If given {@code Boolean} is {@code null} then returns {@code false}
     * otherwise returns given {@code Boolean}
     */
    public static boolean nvl(Boolean value) {
        return value == null ? false : value;
    }
    
}
