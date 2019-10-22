package org.virtuex.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * 加密相关函数。
 *
 * @author renwei
 */
public class SecureUtil {

    private static final String ENC_FLAG = "~|!&";
    private static final String macKey = "TOPMWETYPUIK";
    static SecretKey secret;

    public static byte[] enc3DES(byte[] inputData, byte[] key, boolean useIv)
            throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "DES"));
        return cipher.doFinal(inputData);
    }

    public static byte[] dec3DES(byte[] input, byte[] key, boolean useIv)
            throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "DES"));
        return cipher.doFinal(input);
    }

    public static String enc3DES(String input, byte[] key) throws Exception {
        // 增加加密标记，防止解密时误判
        byte[] encData = enc3DES((ENC_FLAG + input).getBytes(), key, true);
        return Base64.encodeBase64String(encData);
        // return new String(Base64.encode(encData));
    }

    public static String tryDec3DES(String input, byte[] key) throws Exception {
        byte[] decData;
        try {
            decData = dec3DES(Base64.decodeBase64(input), key, true);
        } catch (Exception e) {
            // 不是加密数据
            return input;
        }

        String txt = new String(decData);
        if (txt.startsWith(ENC_FLAG)) {
            return txt.substring(ENC_FLAG.length(), txt.length());
        } else {
            return input;
        }
    }

    /*
     * 用根证书验证证书
     */
    public static void verifyCert(String strCert, String strRootCert)
            throws Exception {
        Certificate cert = buildX509Cert(strCert);
        Certificate certRoot = buildX509Cert(strRootCert);

        cert.verify(certRoot.getPublicKey());
    }

    public static X509Certificate buildX509Cert(String cert) throws Exception {
        return (X509Certificate) CertificateFactory.getInstance("X509")
                .generateCertificate(
                        new ByteArrayInputStream(Base64.decodeBase64(cert)));
    }

    /**
     * 对数据进行HMac摘要，并返回摘要结果的B64字符串
     *
     * @param macData 待运算的值
     * @return
     */
    public static String hmac(String macData) {
        if (secret == null) {
            byte[] secretByte = macKey.getBytes();
            secret = new SecretKeySpec(secretByte, "HMACSHA256");
        }
        byte[] dataBytes = macData.getBytes();
        String b64 = null;
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA256");
            mac.init(secret);
            byte[] doFinal = mac.doFinal(dataBytes);
            b64 = Base64
                    .encodeBase64String(doFinal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b64;
    }
}
