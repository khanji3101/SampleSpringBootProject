package com.khanji.springboot.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザ情報リストDto
 *
 * @author khanji
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoListDto {

    /** ユーザ人数 */
    @Builder.Default
    public String count = "0";

    /** ユーザ情報一覧 */
    public List<UserInfoDto> userInfoDto;

}
