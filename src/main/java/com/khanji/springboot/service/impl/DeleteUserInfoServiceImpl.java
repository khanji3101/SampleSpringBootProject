package com.khanji.springboot.service.impl;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.khanji.springboot.constant.WebMessagesConstant;
import com.khanji.springboot.dto.UserInfoDto;
import com.khanji.springboot.mapper.UserInfoMapper;
import com.khanji.springboot.service.DeleteUserInfoService;
import com.khanji.springboot.util.MessageUtil;

/**
 * ユーザ情報削除サービス実装クラス
 *
 * @author khanji
 *
 */
@Service
@Transactional(readOnly = true)
public class DeleteUserInfoServiceImpl implements DeleteUserInfoService {

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /*
     * (非 Javadoc)
     *
     * @see com.khanji.springboot.service.DeleteUserInfoService#getUserInfo(java.lang.String)
     */
    @Override
    public UserInfoDto getUserInfo(String userId) {
        return this.userInfoMapper.selectUserInfoById(userId);
    }

    /*
     * (非 Javadoc)
     *
     * @see com.khanji.springboot.service.DeleteUserInfoService#deleteUserInfo(java.lang.String)
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteUserInfo(String userId) throws ApplicationException {

        // ユーザ存在チェック
        if (this.userInfoMapper.selectUserInfoCountById(userId) == 0) {
            throw new ApplicationException(
                    this.messageUtil.getMessage(WebMessagesConstant.APP_ERROR_MSG_0001), null);
        }
        // ユーザを削除する
        this.userInfoMapper.deleteUserInfo(userId);
    }

}

