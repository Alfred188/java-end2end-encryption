import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class AESUtility {

    public static byte[] generateRandomSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey().getEncoded();
    }

    public static byte[] encrypt(byte[] value, byte[] secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(secretKey, 0, secretKey.length, "AES"));
        return cipher.doFinal(value);
    }

    public static byte[] decrypt(byte[] encryptedValue, byte[] secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKey, 0, secretKey.length, "AES"));
        return cipher.doFinal(encryptedValue);
    }
}
