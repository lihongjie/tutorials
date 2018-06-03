package com.github.lihongjie.util.uuid;



public class UuidGeneratorImpl implements UuidGenerator {
    
    /** Creates a new instance of UuidGeneratorImpl */
    public UuidGeneratorImpl() {
    }
    
    public String generateUuid() {
        return UuidUtil.generateUuid();
    }
    
    public String generateUuid(Object obj) {
        return UuidUtil.generateUuid(obj);
    }
    
}
