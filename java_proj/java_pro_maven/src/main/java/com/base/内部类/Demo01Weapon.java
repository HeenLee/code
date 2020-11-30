package com.base.内部类;

/**
 * 武器类  和Hearo类关联。英雄人物有好武器
 */
public class Demo01Weapon {
    //武器代号
    private String code;

    public Demo01Weapon() {
    }

    public Demo01Weapon(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
