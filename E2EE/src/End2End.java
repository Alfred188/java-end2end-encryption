public class End2End {

    private byte[] aesSecretKey;
    private RSAUtility rsaUtility;

    End2End() throws Exception {
        rsaUtility = new RSAUtility();
        aesSecretKey = AESUtility.generateRandomSecretKey();
    }

    byte[] getPublicKey() {
        return rsaUtility.getPublicKey();
    }

    public SendModel sendData(String value, byte[] publicKey) throws Exception {
        byte[] encryptedValue = AESUtility.encrypt(value.getBytes(), aesSecretKey);
        byte[] encryptedAESSecretKey = rsaUtility.encrypt(aesSecretKey, publicKey);
        return new SendModel(encryptedValue, encryptedAESSecretKey);
    }

    public String receiveData(byte[] encryptedData, byte[] encryptedAESSecretKey) throws Exception {
        byte[] decryptedAESSecretKey = rsaUtility.decrypt(encryptedAESSecretKey);
        byte[] decryptedData = AESUtility.decrypt(encryptedData, decryptedAESSecretKey);
        return new String(decryptedData);
    }
}

class SendModel {
    private byte[] encryptedData;
    private byte[] encryptedAESSecretKey;

    SendModel(byte[] encryptedData, byte[] encryptedAESSecretKey) {
        this.encryptedData = encryptedData;
        this.encryptedAESSecretKey = encryptedAESSecretKey;
    }

    public byte[] getEncryptedData() {
        return encryptedData;
    }

    public byte[] getEncryptedAESSecretKey() {
        return encryptedAESSecretKey;
    }
}
