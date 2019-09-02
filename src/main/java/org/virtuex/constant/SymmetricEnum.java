package org.virtuex.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description: 对称加密算法枚举类
 * @date 2019/1/22 13:50
 */
public enum SymmetricEnum {
    DES("DES"),
    THREE_DES("3DES"),
    AES("AES")
    ;
    private String symAlgName;
    SymmetricEnum(String symAlgName){
        this.symAlgName = symAlgName;
    }

    public String getSymAlgName(){
        return this.symAlgName;
    }

    public static List<String> getValuesMap() {
        List<String> list = new ArrayList<>();
        for (SymmetricEnum p : SymmetricEnum.values()) {
            list.add(p.getSymAlgName());
        }
        return list;
    }
}
