package org.virtuex.encrypt;

/**
 * 提供一个缺省的配置苦参数家解密引擎
 */
public class DefaultStoreCipherEngine {

    /**
     * 加密配置参数使用的KEY
     */
    private static final byte[] KEY = {0x39, 0x7a, -0x28, 0x6e, -0x1d, 0x24, 0x6f, -0x3b};

    public static String encryptString(String val) {
        try {
            return SecureUtil.enc3DES(val, KEY);
        } catch (Exception e) {
            return val;
        }
    }

    public static String decryptString(String val) {
        try {
            return SecureUtil.tryDec3DES(val, KEY);
        } catch (Exception e) {

            return val;
        }
    }

}
