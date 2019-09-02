package org.virtuex.constant;

import java.util.ArrayList;
import java.util.List;

public enum MacAlgEnum {
    /**
     * 摘要长度160
     */
    HMACSHA1("HMACSHA1"),
    /**
     * 摘要长度224
     */
    HMACSHA224("HMACSHA224"),
    /**
     * 摘要长度256
     */
    HMACSHA256("HMACSHA256"),
    /**
     * 384
     */
    HMACSHA384("HMACSHA384"),
    /**
     * 512
     */
    HMACSHA512("HMACSHA512"),
    /**
     * 128
     */
    HMACMD5("HMACMD5"),
    /**
     * 128
     */
    HMACMD2("HMACMD2"),
    /**
     * 128
     */
    HMACMD4("HMACMD4"),
    ;
    private String macAlgName;
    MacAlgEnum(String macAlgName){
        this.macAlgName = macAlgName;
    }

    public String getMacAlgName(){
        return this.macAlgName;
    }

    public static List<String> getValuesMap() {
        List<String> list = new ArrayList<>();
        for (MacAlgEnum p : MacAlgEnum.values()) {
            list.add(p.getMacAlgName());
        }
        return list;
    }
}
