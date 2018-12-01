package com.khanji.springboot.service.impl;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import com.khanji.springboot.constant.WebMessagesConstant;
import com.khanji.springboot.dto.UserInfoDto;
import com.khanji.springboot.mapper.UserInfoMapper;
import com.khanji.springboot.service.RegistEditUserInfoService;
import com.khanji.springboot.util.MessageUtil;

/**
 * ユーザ情報登録編集サービス実装クラス
 *
 * @author khanji
 *
 */
@Service
@Transactional(readOnly = true)
public class RegistEditUserInfoServiceImpl implements RegistEditUserInfoService {

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /*
     * (非 Javadoc)
     *
     * @see com.khanji.springboot.service.RegistEditUserInfoService#getUserInfo(java.lang.String)
     */
    @Override
    public UserInfoDto getUserInfo(String userId) {
        return this.userInfoMapper.selectUserInfoById(userId);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * com.khanji.springboot.service.RegistEditUserInfoService#registUserInfo(com.khanji.springboot.
     * dto.UserInfoDto)
     */
    @Override
    @Transactional(readOnly = false)
    public void registUserInfo(UserInfoDto userInfoDto) throws ApplicationException {

        Timestamp sysdate = new Timestamp(System.currentTimeMillis());

        UserInfoDto editUserInfoDto = UserInfoDto.builder().build();
        editUserInfoDto = this.editUserInfoDto(userInfoDto);
        editUserInfoDto.setInsertDate(sysdate);
        editUserInfoDto.setVersion(1);

        // オブジェクト内値チェック
        if (!isRegistEditFormInfoValidate(editUserInfoDto)) {
            throw new ApplicationException(this.messageUtil.getMessage(
                    WebMessagesConstant.APP_ERROR_MSG_0002, editUserInfoDto.getUserName()), null);
        }
        // ユーザ情報を登録
        this.userInfoMapper.registUserInfo(editUserInfoDto);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * com.khanji.springboot.service.RegistEditUserInfoService#updateUserInfo(com.khanji.springboot.
     * dto.UserInfoDto)
     */
    @Override
    @Transactional(readOnly = false)
    public void updateUserInfo(UserInfoDto userInfoDto) throws ApplicationException {

        Timestamp sysdate = new Timestamp(System.currentTimeMillis());

        UserInfoDto editUserInfoDto = UserInfoDto.builder().build();
        editUserInfoDto = this.editUserInfoDto(userInfoDto);
        editUserInfoDto.setUpdateDate(sysdate);
        editUserInfoDto.setVersion(userInfoDto.getVersion() + 1);

        // オブジェクト内値チェック
        if (!isRegistEditFormInfoValidate(editUserInfoDto)) {
            throw new ApplicationException(this.messageUtil.getMessage(
                    WebMessagesConstant.APP_ERROR_MSG_0002, editUserInfoDto.getUserName()), null);
        }

        // ユーザ情報を更新
        this.userInfoMapper.updateUserInfo(editUserInfoDto);

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * com.khanji.springboot.service.RegistEditUserInfoService#checkRegistFormUserInfo(com.khanji.
     * springboot.dto.UserInfoDto)
     */
    @Override
    public void checkRegistFormUserInfo(UserInfoDto userInfoDto) throws ApplicationException {

        UserInfoDto editUserInfoDto = UserInfoDto.builder().build();
        editUserInfoDto = this.editUserInfoDto(userInfoDto);

        if (!this.isRegistEditFormInfoValidate(editUserInfoDto)) {
            throw new ApplicationException(this.messageUtil.getMessage(
                    WebMessagesConstant.APP_ERROR_MSG_0002, editUserInfoDto.getUserName()), null);
        }

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * com.khanji.springboot.service.RegistEditUserInfoService#checkRegistFormUserInfo(com.khanji.
     * springboot.dto.UserInfoDto)
     */
    @Override
    public void checkEditFormUserInfo(UserInfoDto userInfoDto) throws ApplicationException {

        UserInfoDto editUserInfoDto = UserInfoDto.builder().build();
        editUserInfoDto = this.editUserInfoDto(userInfoDto);

        if (!this.isRegistEditFormInfoValidate(editUserInfoDto)) {
            throw new ApplicationException(this.messageUtil.getMessage(
                    WebMessagesConstant.APP_ERROR_MSG_0002, userInfoDto.getUserName()), null);
        }

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * com.khanji.springboot.service.RegistEditUserInfoService#isCheckUserInfo(com.khanji.springboot
     * .dto.UserInfoDto)
     */
    public boolean isCheckUserInfo(UserInfoDto userInfoDto) {

        UserInfoDto checkUserInfoDto =
                this.userInfoMapper.selectUserInfoById(userInfoDto.getUserId());

        if (StringUtils.equals(checkUserInfoDto.getUserName(), userInfoDto.getUserName())) {
            return false;
        } else if (StringUtils.equals(checkUserInfoDto.getUserSex(), userInfoDto.getUserSex())) {
            return false;
        } else if (StringUtils.equals(checkUserInfoDto.getUserAge(), userInfoDto.getUserAge())
                && isNumberMatch(checkUserInfoDto.getUserSex())) {
            return false;
        }
        return true;

    }

    /**
     * 共通ユーザ情報項目設定処理
     *
     * @param userInfoDto ユーザ情報Dto
     * @return ユーザ情報Dto
     */
    private UserInfoDto editUserInfoDto(UserInfoDto userInfoDto) {

        userInfoDto.setUserId(userInfoDto.getUserId());
        userInfoDto.setUserName(userInfoDto.getUserName());
        userInfoDto.setUserSex(userInfoDto.getUserSex());
        userInfoDto
                .setUserAge(Normalizer.normalize(userInfoDto.getUserAge(), Normalizer.Form.NFKC));
        return userInfoDto;
    }

    /**
     * 登録・編集フォーム入力値判定処理
     *
     * @param usersInfoDto ユーザ情報Dto
     * @return 真偽値
     */
    private boolean isRegistEditFormInfoValidate(UserInfoDto userInfoDto) {
        if (StringUtils.isEmpty(userInfoDto.getUserName())) {
            return false;
        } else if (StringUtils.isEmpty(userInfoDto.getUserSex())) {
            return false;
        } else if (StringUtils.isEmpty(userInfoDto.getUserAge())) {
            return false;
        }
        return true;
    }

    /**
     * 数値チェック処理
     *
     * @param num 判定対象数値
     * @return 真偽値
     */
    private boolean isNumberMatch(String num) {
        Pattern pattern = java.util.regex.Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }

}

