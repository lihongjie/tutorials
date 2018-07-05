package com.github.lihongjie.core.base.util.collections;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CollectionUtilsTest {

    @Test
    public void isEqualCollection() {

        List<String> collectionA = Arrays.asList("A", "B", "C");
        List<String> collectionB = Arrays.asList("C", "B", "A");



         CollectionUtils.isEqualCollection(collectionA, collectionB);
    }

}
