package com.github.lihongjie.core.base.util;


import com.github.lihongjie.core.common.IdGenerator;

public class SequenceUtils {

    private static IdGenerator idGenerator = new IdGenerator();

    public static String nexSeqId() {

        return idGenerator.nexSeqId();
    }


    private SequenceUtils() {

    }
}
