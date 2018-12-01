package com.khanji.springboot.enums;

import lombok.Getter;

/**
 * 性別Enumクラス
 *
 * @author khanji
 *
 */
public enum HumanSexEnum {

    MALE("男", "0"), FEMALE("女", "1");

    @Getter
    private String value;

    @Getter
    private String key;

    private HumanSexEnum(String value, String key) {
        this.value = value;
        this.key = key;
    }

}
