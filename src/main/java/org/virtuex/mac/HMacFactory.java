package org.virtuex.mac;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.virtuex.constant.MacAlgEnum;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * MAC消息摘要组件
 *
 * @author kongqz
 */
public class HMacFactory {
    private Mac mac;
    private SecretKey security;
    private byte[] keyByte;

    public static HMacFactory getInstance(String hmacAlg) throws Exception {
        if (!MacAlgEnum.getValuesMap().contains(hmacAlg.toUpperCase())) {
            throw new Exception("未知的算法");
        } else {
            return new HMacFactory(hmacAlg);
        }
    }

    private HMacFactory(String hmacAlg) throws NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        KeyGenerator keyGenerator = KeyGenerator.getInstance(hmacAlg);
        security = keyGenerator.generateKey();
        keyByte = security.getEncoded();
        mac = Mac.getInstance(hmacAlg);
    }

    public byte[] encodeMac(byte[] data) throws Exception {
        //生成密钥
        mac.init(security);
        byte[] bytes = mac.doFinal(data);
        return bytes;
    }

    public String encodeMacHex(byte[] data) throws Exception {
        return Hex.encodeHexString(encodeMac(data));
    }


    public static void main(String[] args) throws Exception {
        HMacFactory hmacmd5 = HMacFactory.getInstance("HMACMD5");
        System.out.println(hmacmd5.encodeMacHex("aaa".getBytes()));
        System.out.println(Hex.encodeHexString(hmacmd5.keyByte));
    }

}