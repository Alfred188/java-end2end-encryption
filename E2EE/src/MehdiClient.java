import java.util.Base64;
import java.util.Scanner;

@SuppressWarnings("ALL")
class MehdiClient {

    public static void main(String[] args) throws Exception {
        End2End end2End = new End2End();
        System.out.println("your public key is:");
        System.out.println(Base64.getEncoder().encodeToString(end2End.getPublicKey()));
        initialize(end2End);
    }

    private static void initialize(End2End end2End) throws Exception {
        System.out.println("\nplease choose your action?\n 1- send data\n 2- receive data");
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                System.out.println("please enter your data");
                String data = new Scanner(System.in).nextLine();
                System.out.println("please enter receiver public key");
                byte[] receiverPublicKey = Base64.getDecoder().decode(new Scanner(System.in).nextLine());
                SendModel sendModel = end2End.sendData(data, receiverPublicKey);
                System.out.println("your data secret key is:");
                System.out.println(Base64.getEncoder().encodeToString(sendModel.getEncryptedAESSecretKey()));
                System.out.println("your encrypted data is:");
                System.out.println(Base64.getEncoder().encodeToString(sendModel.getEncryptedData()));
                initialize(end2End);
                break;
            case 2:
                System.out.println("please enter data secret key");
                byte[] encryptedSecretKey = Base64.getDecoder().decode(new Scanner(System.in).next());
                System.out.println("please enter encrypted data");
                byte[] encryptedData = Base64.getDecoder().decode(new Scanner(System.in).next());
                String decryptedData = end2End.receiveData(encryptedData, encryptedSecretKey);
                System.out.println("your data is:");
                System.out.println(decryptedData);
                initialize(end2End);
                break;
        }
    }
}

@SuppressWarnings("ALL")
class ShahramClient {

    public static void main(String[] args) throws Exception {
        End2End end2End = new End2End();
        System.out.println("your public key is:");
        System.out.println(Base64.getEncoder().encodeToString(end2End.getPublicKey()));
        initialize(end2End);
    }

    private static void initialize(End2End end2End) throws Exception {
        System.out.println("\nplease choose your action?\n 1- send data\n 2- receive data");
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                System.out.println("please enter your data");
                String data = new Scanner(System.in).nextLine();
                System.out.println("please enter receiver public key");
                byte[] receiverPublicKey = Base64.getDecoder().decode(new Scanner(System.in).nextLine());
                SendModel sendModel = end2End.sendData(data, receiverPublicKey);
                System.out.println("your data secret key is:");
                System.out.println(Base64.getEncoder().encodeToString(sendModel.getEncryptedAESSecretKey()));
                System.out.println("your encrypted data is:");
                System.out.println(Base64.getEncoder().encodeToString(sendModel.getEncryptedData()));
                initialize(end2End);
                break;
            case 2:
                System.out.println("please enter data secret key");
                byte[] encryptedSecretKey = Base64.getDecoder().decode(new Scanner(System.in).next());
                System.out.println("please enter encrypted data");
                byte[] encryptedData = Base64.getDecoder().decode(new Scanner(System.in).next());
                String decryptedData = end2End.receiveData(encryptedData, encryptedSecretKey);
                System.out.println("your data is:");
                System.out.println(decryptedData);
                initialize(end2End);
                break;
        }
    }
}
