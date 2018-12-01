package com.khanji.springboot.service;

import org.omg.CORBA.portable.ApplicationException;
import com.khanji.springboot.dto.UserInfoDto;

/**
 * ユーザ情報削除サービスクラス
 *
 * @author khanji
 *
 */
public interface DeleteUserInfoService {

    /**
     * ユーザ情報取得処理
     *
     * @return ユーザ情報Dto
     */
    public UserInfoDto getUserInfo(String userId);

    /**
     * ユーザ情報削除処理
     *
     * @param id ユーザId
     * @throws ApplicationException
     */
    public void deleteUserInfo(String userId) throws ApplicationException;

}
