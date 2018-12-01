package com.khanji.springboot.service;

import org.omg.CORBA.portable.ApplicationException;
import com.khanji.springboot.dto.UserInfoDto;

/**
 * ユーザ情報登録編集サービスクラス
 *
 * @author khanji
 *
 */
public interface RegistEditUserInfoService {

    /**
     * ユーザ情報取得
     *
     * @param userId ユーザ
     * @return ユーザ情報Dto
     */
    public UserInfoDto getUserInfo(String userId);

    /**
     * ユーザ情報登録処理
     *
     * @param userInfoDto ユーザ情報Dto
     * @throws ApplicationException エラー情報
     */
    public void registUserInfo(UserInfoDto usersInfoDto) throws ApplicationException;

    /**
     * ユーザ情報更新処理
     *
     * @param userInfoDto ユーザ情報Dto
     * @throws ApplicationException エラー情報
     */
    public void updateUserInfo(UserInfoDto usersInfoDto) throws ApplicationException;

    /**
     * ユーザ情報登録入力画面フォームチェック
     *
     * @param userInfoDto ユーザ情報Dto
     */
    public void checkRegistFormUserInfo(UserInfoDto userInfoDto) throws ApplicationException;

    /**
     * ユーザ情報編集入力画面フォームチェック
     *
     * @param userInfoDto ユーザ情報Dto
     */
    public void checkEditFormUserInfo(UserInfoDto userInfoDto) throws ApplicationException;

    /**
     * 編集画面から戻った際のユーザ情報チェック
     * 
     * @param userInfoDto ユーザ情報Dto
     * @return 真偽値
     */
    public boolean isCheckUserInfo(UserInfoDto userInfoDto);

}
