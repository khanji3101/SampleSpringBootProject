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
import com.khanji.springboot.dto.UserInfoDto;
import com.khanji.springboot.service.RegistEditUserInfoService;

/**
 * ユーザ登録コントローラクラス
 *
 * @author khanji
 *
 */
@Controller
public class RegistUserInfoController {

    @Autowired
    private RegistEditUserInfoService registEditUserInfoService;

    @RequestMapping(value = UrlConstant.URL_INIT_REGIST_USERINFO, method = {GET, POST})
    public String initRegistUserInfo(@ModelAttribute UserInfoDto userInfoDto, Model model) {
        model.addAttribute("user", userInfoDto);
        return ViewConstant.VIEW_REGIST_USERINFO;
    }

    @RequestMapping(value = UrlConstant.URL_REGIST_USERINFO, method = POST)
    public String registUserInfo(@ModelAttribute UserInfoDto userInfoDto,
            RedirectAttributes redirectAttributes) {

        try {
            this.registEditUserInfoService.checkRegistFormUserInfo(userInfoDto);
            redirectAttributes.addFlashAttribute("userInfoDto", userInfoDto);
        } catch (ApplicationException e) {
            redirectAttributes.addFlashAttribute("error", e.getId());
            redirectAttributes.addFlashAttribute("userInfoDto", userInfoDto);
            return CommonConstant.COMMON_REDIRECT + UrlConstant.URL_INIT_REGIST_USERINFO;
        }
        return CommonConstant.COMMON_REDIRECT + UrlConstant.URL_INIT_REGIST_CONFIRM_USERINFO;
    }

}
