package org.virtuex.hex;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;

public class EncodeUtil {
    /**
     * 十六进制转十进制
     * @param hex
     * @return
     * @throws Exception
     */
    public static String hex2Oct(String hex) throws Exception {
        try {
            return hex == null ? null : new BigInteger(Hex.decodeHex(hex.toCharArray())).toString();
        } catch (DecoderException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * 十进制转十六进制
     * @param oct
     * @return
     */
    public static String oct2Hex(String oct) {
        return oct == null ? null : new String(Hex.encodeHex(new BigInteger(oct).toByteArray())).toUpperCase();
    }

    /**
     * 字节数组转十六进制
     * @param bytes
     * @return
     */
    public static String byte2Hex(byte[] bytes){
      return Hex.encodeHexString(bytes);
    }

}
