import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtility {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public RSAUtility() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
    }

    public byte[] getPublicKey() {
        return this.publicKey.getEncoded();
    }

    public byte[] encrypt(byte[] value, byte[] publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, bytesToPublicKey(publicKey));
        return cipher.doFinal(value);
    }

    public byte[] decrypt(byte[] encryptedValue) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(encryptedValue);
    }

    private PublicKey bytesToPublicKey(byte[] value) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(value);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(x509EncodedKeySpec);
    }
}
