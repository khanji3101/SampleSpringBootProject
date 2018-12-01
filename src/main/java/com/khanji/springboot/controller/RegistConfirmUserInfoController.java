package com.khanji.springboot.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.khanji.springboot.constant.CommonConstant;
import com.khanji.springboot.constant.UrlConstant;
import com.khanji.springboot.constant.ViewConstant;
import com.khanji.springboot.constant.WebMessagesConstant;
import com.khanji.springboot.dto.UserInfoDto;
import com.khanji.springboot.service.RegistEditUserInfoService;
import com.khanji.springboot.util.MessageUtil;

/**
 * ユーザ登録確認コントローラクラス
 *
 * @author khanji
 *
 */
@Controller
public class RegistConfirmUserInfoController {

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private RegistEditUserInfoService registEditUserInfoService;

    @RequestMapping(value = UrlConstant.URL_INIT_REGIST_CONFIRM_USERINFO, method = {GET, POST})
    public String initRegistConfirmUserInfo(@ModelAttribute UserInfoDto userInfoDto, Model model) {
        model.addAttribute("user", userInfoDto);
        return ViewConstant.VIEW_REGIST_CONFIRM_USERINFO;
    }

    @RequestMapping(value = UrlConstant.URL_EXEC_REGIST_CONFIRM_USERINFO, method = POST)
    public String execRegistConfirmUserInfo(@ModelAttribute UserInfoDto userInfoDto,
            RedirectAttributes redirectAttributes) {
        try {
            this.registEditUserInfoService.registUserInfo(userInfoDto);
            redirectAttributes.addFlashAttribute("info", this.messageUtil
                    .getMessage(WebMessagesConstant.APP_INFO_MSG_0001, userInfoDto.getUserName()));
        } catch (ApplicationException e) {
            redirectAttributes.addFlashAttribute("error", e.getId());
            redirectAttributes.addFlashAttribute("userInfoDto", userInfoDto);
            return CommonConstant.COMMON_REDIRECT + UrlConstant.URL_INIT_REGIST_CONFIRM_USERINFO;
        }
        return CommonConstant.COMMON_REDIRECT + UrlConstant.URL_INIT_INDEX_USERINFO;
    }

}
