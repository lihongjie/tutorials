package com.github.lihongjie.util.uuid;

/**
 *
 * @author  lwhite
 */
public class UuidUtilPadded extends UuidUtil {
    
    static final int DESIRED_UUID_LENGTH = 40;
    
    //this method can take in the session object
    //and insure better uniqueness guarantees
    //needed length must be greater than not less than
    //expected returned lengths - i.e. at least 40
    public static String generateUuid(Object obj, int inputLength) {
        int desiredLength = 
            DESIRED_UUID_LENGTH >= inputLength ? DESIRED_UUID_LENGTH:inputLength;
        String unpaddedUuid = UuidUtil.generateUuid(obj);
        StringBuffer sb = new StringBuffer(unpaddedUuid);
        int neededPadding = desiredLength - unpaddedUuid.length();
        //int neededPadding = DESIRED_UUID_LENGTH - unpaddedUuid.length();
        if(neededPadding > 0) {
            for(int i=0; i<neededPadding; i++) {
                sb.append("F");
            }
        }
        return sb.toString();
    }    
    
    /**
     * Method main
     *
     *
     * @param args
     *
     * @audience
     */
    public static void main(String[] args) {
        System.out.println(UuidUtilPadded.generateUuidMM());
        System.out.println(UuidUtilPadded.generateUuid());
        System.out.println(UuidUtilPadded.generateUuid(new Object()));
        System.out.println(UuidUtilPadded.generateUuid(new Object(), 40));
    }
    
}
