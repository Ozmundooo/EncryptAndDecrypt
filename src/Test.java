import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Test {
    public static void main(String[] args) throws Exception
    {
        EncryptAndDecrypt enc = new EncryptAndDecrypt();
        enc.enc();
        System.out.println(new String(enc.getEnc()));
        enc.dec();
        System.out.println(new String(enc.getDec()));
    }
}
