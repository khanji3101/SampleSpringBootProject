package com.khanji.springboot.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザ情報Dto
 *
 * @author khanji
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDto {

    /** ユーザId */
    public String userId;

    /** ユーザ名 */
    public String userName;

    /** 性別 */
    public String userSex;

    /** 年齢 */
    public String userAge;

    /** 登録日時 */
    public Timestamp insertDate;

    /** 更新日時 */
    public Timestamp updateDate;

    /** バージョン */
    public int version;

}
