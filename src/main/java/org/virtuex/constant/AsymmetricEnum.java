package org.virtuex.constant;


import java.util.ArrayList;
import java.util.List;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description: 非对称算法枚举类
 * @date 2019/1/22 13:52
 */
public enum AsymmetricEnum {
    RSA("RSA"),
    ECC("ECC")
    ;
    private String asymAlgName;
    AsymmetricEnum(String asymAlgName){
        this.asymAlgName = asymAlgName;
    }

    public String getAsymAlgName(){
        return this.asymAlgName;
    }

    public static List<String> getValuesMap() {
        List<String> list = new ArrayList<>();
        for (AsymmetricEnum p : AsymmetricEnum.values()) {
            list.add(p.getAsymAlgName());
        }
        return list;
    }
}
