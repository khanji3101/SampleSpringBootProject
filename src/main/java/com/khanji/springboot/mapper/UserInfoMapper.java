package com.khanji.springboot.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.khanji.springboot.dto.UserInfoDto;

/**
 * ユーザ情報マッパークラス
 *
 * @author khanji
 *
 */
@Mapper
public interface UserInfoMapper {

    /**
     * ユーザ総人数取得
     *
     * @return ユーザカウント数
     */
    public int selectUserCount();

    /**
     * ユーザ存在数取得
     *
     * @param userId ユーザId
     * @return ユーザカウント数
     */
    public int selectUserInfoCountById(@Param("userId") String userId);

    /**
     * ユーザ情報取得
     *
     * @param userId ユーザId
     * @return UserInfoDto ユーザ情報Dto
     */
    public UserInfoDto selectUserInfoById(@Param("userId") String userId);

    /**
     * ユーザ情報一覧取得処理
     *
     * @return UserInfoDto(List) ユーザ情報Dto
     */
    public List<UserInfoDto> selectUsersInfoList();

    /**
     * ユーザ情報登録処理
     *
     * @param userInfoDto ユーザ情報Dto
     */
    public void registUserInfo(@Param("form") UserInfoDto userInfoDto);

    /**
     * ユーザ情報更新処理
     *
     * @param userInfoDto ユーザ情報Dto
     */
    public void updateUserInfo(@Param("form") UserInfoDto userInfoDto);

    /**
     * ユーザ情報削除処理
     *
     * @param userId ユーザID
     */
    public void deleteUserInfo(@Param("userId") String userId);


}
