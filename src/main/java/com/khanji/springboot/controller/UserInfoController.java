package com.khanji.springboot.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.khanji.springboot.constant.UrlConstant;
import com.khanji.springboot.constant.ViewConstant;
import com.khanji.springboot.service.UserInfoService;

/**
 * ユーザ情報コントローラクラス
 *
 * @author khanji
 *
 */
@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = UrlConstant.URL_INIT_INDEX_USERINFO, method = {GET, POST})
    public String initIndexInfo(Model model) {
        model.addAttribute("users", this.userInfoService.getUserInfoList());
        return ViewConstant.VIEW_INDEX;
    }

}
