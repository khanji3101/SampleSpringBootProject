package com.khanji.springboot.service;

import com.khanji.springboot.dto.UserInfoDto;
import com.khanji.springboot.dto.UserInfoListDto;

/**
 * ユーザ情報サービスクラス
 *
 * @author khanji
 *
 */
public interface UserInfoService {

    /**
     * ユーザ情報取得
     *
     * @param userId ユーザId
     * @return ユーザ情報Dto
     */
    public UserInfoDto getUserInfo(String userId);

    /**
     * ユーザ情報リスト取得
     *
     * @return ユーザ情報リストDto
     */
    public UserInfoListDto getUserInfoList();

}
