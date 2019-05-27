import java.security.*;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;


public class EncryptAndDecrypt
{
    String input;
    String key;
    Key aesKey;
    Cipher cipher;
    byte[] encData, decData;

    public EncryptAndDecrypt()throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException
    {
        input = inputString();
        key ="Bar12345Bar12345";
        genKey();
        genCipher();
    }

    public String inputString()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("What would you like to send?:" );
        input = scan.nextLine();
        System.out.println("");
        return input;
    }

    public void genKey()
    {
        aesKey = new SecretKeySpec(key.getBytes(),"AES");
    }

    public void genCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException
    {
        cipher = Cipher.getInstance("AES");

    }

    public void enc() throws Exception
    {
        cipher.init(Cipher.ENCRYPT_MODE,aesKey);
        encData = cipher.doFinal(input.getBytes());
    }

    public void enc(String inputText) throws Exception
    {
        cipher.init(Cipher.ENCRYPT_MODE,aesKey);
        encData = cipher.doFinal(inputText.getBytes());
    }

    public byte[] getEnc()
    {
        return encData;
    }

    public void dec() throws Exception
    {
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        decData = cipher.doFinal(encData);
    }

    public void dec(byte[] encDataText) throws Exception
    {
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        decData = cipher.doFinal(encDataText);
    }

    public byte[] getDec(){return decData;}
}
