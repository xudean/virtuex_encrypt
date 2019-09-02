package org.virtuex.base64;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class Base64CoderTest {
    @Test
    public void test1(){
        System.out.println(new String(Base64Coder.encode("111".getBytes())));
    }

}
