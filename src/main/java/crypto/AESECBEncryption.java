package crypto;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class AESECBEncryption {
    public static void main(String[] args) {
        String input = "iab";
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey secretKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            cipher.update(input.getBytes());
            byte[] bytes = cipher.doFinal();
            System.out.println(Arrays.toString(bytes));
            String cipherText = Base64.getEncoder().encodeToString(bytes);
            System.out.println("CipherText = " + cipherText);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            cipher.update(Base64.getDecoder().decode(cipherText));
            System.out.println("Input = " + new String(cipher.doFinal()));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
    }
}
