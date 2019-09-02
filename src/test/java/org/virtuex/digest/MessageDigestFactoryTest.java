package org.virtuex.digest;

import org.junit.Test;
import org.virtuex.constant.DigestAlgEnum;

import java.io.File;

import static org.junit.Assert.*;

public class MessageDigestFactoryTest {

    @Test
    public void md5() {
        try {
            MessageDigestFactory instance = MessageDigestFactory.getInstance(DigestAlgEnum.MD5.name());
            String b64Str = instance.digest2Base64("aaa");
            String hexStr = instance.digest2Hex("aaa");
            String fileMd5 = instance.digestFile2Base64(new File("1.txt"));
            System.out.println("BASE64:"+b64Str);
            System.out.println("HEX:"+hexStr);
            System.out.println("FILE:"+fileMd5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void md4() {
        try {
            MessageDigestFactory instance = MessageDigestFactory.getInstance(DigestAlgEnum.MD4.name());
            String b64Str = instance.digest2Base64("aaa");
            String hexStr = instance.digest2Hex("aaa");
            String fileMd5 = instance.digestFile2Base64(new File("1.txt"));
            System.out.println("BASE64:"+b64Str);
            System.out.println("HEX:"+hexStr);
            System.out.println("FILE:"+fileMd5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sha1() {
        try {
            MessageDigestFactory instance = MessageDigestFactory.getInstance(DigestAlgEnum.SHA1.name());
            String b64Str = instance.digest2Base64("aaa");
            String hexStr = instance.digest2Hex("aaa");
            String fileMd5 = instance.digestFile2Base64(new File("1.txt"));
            System.out.println("BASE64:"+b64Str);
            System.out.println("HEX:"+hexStr);
            System.out.println("FILE:"+fileMd5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sha224() {
        try {
            MessageDigestFactory instance = MessageDigestFactory.getInstance(DigestAlgEnum.SHA224.name());
            String b64Str = instance.digest2Base64("aaa");
            String hexStr = instance.digest2Hex("aaa");
            String fileMd5 = instance.digestFile2Base64(new File("1.txt"));
            System.out.println("BASE64:"+b64Str);
            System.out.println("HEX:"+hexStr);
            System.out.println("FILE:"+fileMd5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sha256() {
        try {
            MessageDigestFactory instance = MessageDigestFactory.getInstance(DigestAlgEnum.SHA256.name());
            String b64Str = instance.digest2Base64("aaa");
            String hexStr = instance.digest2Hex("aaa");
            String fileMd5 = instance.digestFile2Base64(new File("1.txt"));
            System.out.println("BASE64:"+b64Str);
            System.out.println("HEX:"+hexStr);
            System.out.println("FILE:"+fileMd5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sha384() {
        try {
            MessageDigestFactory instance = MessageDigestFactory.getInstance(DigestAlgEnum.SHA384.name());
            String b64Str = instance.digest2Base64("aaa");
            String hexStr = instance.digest2Hex("aaa");
            String fileMd5 = instance.digestFile2Base64(new File("1.txt"));
            System.out.println("BASE64:"+b64Str);
            System.out.println("HEX:"+hexStr);
            System.out.println("FILE:"+fileMd5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sha512() {
        try {
            MessageDigestFactory instance = MessageDigestFactory.getInstance(DigestAlgEnum.SHA512.name());
            String b64Str = instance.digest2Base64("aaa");
            String hexStr = instance.digest2Hex("aaa");
            String fileMd5 = instance.digestFile2Base64(new File("1.txt"));
            System.out.println("BASE64:"+b64Str);
            System.out.println("HEX:"+hexStr);
            System.out.println("FILE:"+fileMd5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}