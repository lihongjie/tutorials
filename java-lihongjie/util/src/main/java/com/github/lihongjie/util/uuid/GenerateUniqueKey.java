package com.github.lihongjie.util.uuid;

import java.rmi.server.UID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * Generate a unique number/key using UUID, UID and MessageDigest
 *
 - Generated UUID : 4e4deff9-b027-4359-8ad5-320e429b5739
 - Generated UID: 3e336481:14ed674b5d1:-8000
 - Generated Randon number: -164701456
 - Generated Message digest: otopo6oro6oooto7opo6oqososoqoso4oto9o1o2o5opo0o8o0o6o4oroto5o7op
 *
 *
 */
public class GenerateUniqueKey {



    public String generateUniqueKeyUsingUUID() {
        // Static factory to retrieve a type 4 (pseudo randomly generated) UUID
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public String generateUniqueKeyUsingUID() {
        UID uid = new UID();
        return uid.toString();
    }

    public void generateUniqueKeyUsingMessageDigest() {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

            // generate a random number
            String randomNumber = new Integer(secureRandom.nextInt()).toString();

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            byte[] bytes = messageDigest.digest(randomNumber.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

}
