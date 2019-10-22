package org.virtuex.encrypt;


/**
 * 处理敏感字段的引擎
 */
public interface ISFCipherEngine {

    /**
     * 配合 日志记录器 使用， 记录日志的时候进行过滤
     *
     * @param plainText
     * @return cryptedText
     */
    String filterLog(String plainText);

    /**
     * 配合 DAO 使用，在数据进入数据库之前对其加密
     *
     * @param plainText
     * @return cryptedText
     */
    String encrypt(String plainText);

    /**
     * 配合 DAO 使用，在数据从数据库出来之后对其解密
     *
     * @param cryptedText
     * @return plainText
     */
    String decrypt(String cryptedText);

}
