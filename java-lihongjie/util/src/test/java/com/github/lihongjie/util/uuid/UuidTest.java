package com.github.lihongjie.util.uuid;

import org.junit.Test;

import java.util.UUID;

public class UuidTest {

    @Test
    public void testJdkUuid() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }

    @Test
    public void testUuidUtil() {
        String uuid = UuidUtil.generateUuid();
        System.out.println(uuid);
    }

    @Test
    public void testUuidUtilMM() {
        String uuid = UuidUtil.generateUuidMM();
        System.out.println(uuid);
    }

    @Test
    public void testUuidUtilObject() {
        String uuid = UuidUtil.generateUuid(new Object());
        System.out.println(uuid);
    }
}
