package com.khanji.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import com.khanji.springboot.dto.UserInfoDto;
import com.khanji.springboot.dto.UserInfoListDto;
import com.khanji.springboot.mapper.UserInfoMapper;
import com.khanji.springboot.service.UserInfoService;

/**
 * ユーザ情報サービス実装クラス
 *
 * @author khanji
 *
 */
@Service
@Transactional(readOnly = true)
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /*
     * (非 Javadoc)
     * 
     * @see com.khanji.springboot.service.UserInfoService#getUserInfo(java.lang.String)
     */
    @Override
    public UserInfoDto getUserInfo(String userId) {
        return this.userInfoMapper.selectUserInfoById(userId);
    }

    /*
     * (非 Javadoc)
     * 
     * @see com.khanji.springboot.service.UserInfoService#getUserInfoList()
     */
    @Override
    public UserInfoListDto getUserInfoList() {

        // ユーザ情報Dtoに[1.ユーザ人数, 2.ユーザ情報一覧]を挿入
        UserInfoListDto userInfoListDto = UserInfoListDto.builder().build();
        userInfoListDto.setCount(StringUtils.toString(this.userInfoMapper.selectUserCount()));
        userInfoListDto.setUserInfoDto(this.userInfoMapper.selectUsersInfoList());

        return userInfoListDto;
    }

}

