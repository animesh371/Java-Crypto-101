package crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Hashing {

    public static void main(String[] args) {
        String input = "A";
        System.out.println(Arrays.toString(input.getBytes()));
        System.out.println(Base64.getEncoder().encodeToString(input.getBytes()));
        System.out.println(new String(Base64.getDecoder().decode("QQQQ")));
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            System.out.println(Base64.getEncoder().encodeToString(sha1.digest(input.getBytes())) + " - SHA-1");
            System.out.println(Base64.getEncoder().encodeToString(sha256.digest(input.getBytes())) + " - SHA-256");
            System.out.println(Base64.getEncoder().encodeToString(md5.digest(input.getBytes())) + " - MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
