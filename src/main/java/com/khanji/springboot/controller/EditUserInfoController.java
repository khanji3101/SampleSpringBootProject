package com.khanji.springboot.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.khanji.springboot.constant.UrlConstant;
import com.khanji.springboot.constant.ViewConstant;
import com.khanji.springboot.dto.UserInfoDto;
import com.khanji.springboot.service.RegistEditUserInfoService;

/**
 * ユーザ編集コントローラクラス
 *
 * @author khanji
 *
 */
@Controller
public class EditUserInfoController {

    @Autowired
    private RegistEditUserInfoService registEditUserInfoService;

    @RequestMapping(value = UrlConstant.URL_INIT_EDIT_USERINFO, method = {GET, POST})
    public String initEditUserInfo(@ModelAttribute UserInfoDto userInfoDto, Model model) {

        if (this.registEditUserInfoService.isCheckUserInfo(userInfoDto)) {
            model.addAttribute("user",
                    this.registEditUserInfoService.getUserInfo(userInfoDto.getUserId()));
        } else {
            model.addAttribute("user", userInfoDto);
        }
        return ViewConstant.VIEW_EDIT_USERINFO;
    }

    @RequestMapping(value = UrlConstant.URL_EDIT_USERINFO, method = POST)
    public String editUserInfo(@ModelAttribute UserInfoDto userInfoDto,
            RedirectAttributes redirectAttributes) {
        try {
            this.registEditUserInfoService.checkEditFormUserInfo(userInfoDto);
            redirectAttributes.addFlashAttribute("userInfoDto", userInfoDto);
        } catch (ApplicationException e) {
            redirectAttributes.addFlashAttribute("error", e.getId());
            redirectAttributes.addFlashAttribute("userInfoDto", userInfoDto);
            return "redirect:" + UrlConstant.URL_INIT_EDIT_USERINFO;
        }
        return "redirect:" + UrlConstant.URL_INIT_EDIT_CONFIRM_USERINFO;
    }

}
