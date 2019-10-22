package org.virtuex.encrypt;

public class SFCipherEngines {

    public static class Inner {

        private static final ISFCipherEngine PLAIN_ENGINE = new ISFCipherEngine() {
            @Override
            public String filterLog(String plainText) {
                return plainText;
            }

            @Override
            public String encrypt(String plainText) {
                return plainText;
            }

            @Override
            public String decrypt(String cryptedText) {
                return cryptedText;
            }
        };

        /**
         * 使用了配置库的引擎 {@link DefaultStoreCipherEngine}
         */
        private static final ISFCipherEngine FILL_START_AND_3DES_ENGINE = new ISFCipherEngine() {

            @Override
            public String filterLog(String encrypt) {
                return "******";
            }

            @Override
            public String encrypt(String plainText) {
                return DefaultStoreCipherEngine.encryptString(plainText);
            }

            @Override
            public String decrypt(String cryptedText) {
                return DefaultStoreCipherEngine.decryptString(cryptedText);
            }
        };
    }

    public static ISFCipherEngine getFlainEngine() {
        return Inner.PLAIN_ENGINE;
    }

    public static ISFCipherEngine getFillStarAnd3DesEngine() {
        return Inner.FILL_START_AND_3DES_ENGINE;
    }

}
