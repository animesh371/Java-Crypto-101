package crypto;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AESCBCEncryption {
    public static void main(String[] args) {
        String input = "inputinput";
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey secretKey = keyGenerator.generateKey();
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] random = new byte[16];
            secureRandom.nextBytes(random);
            IvParameterSpec iv = new IvParameterSpec(random);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            cipher.update(input.getBytes());
            String cipherText = Base64.getEncoder().encodeToString(cipher.doFinal());
            System.out.println("CipherText = " + cipherText);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            cipher.update(Base64.getDecoder().decode(cipherText));
            System.out.println("Input = " + new String(cipher.doFinal()));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException
                | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}
