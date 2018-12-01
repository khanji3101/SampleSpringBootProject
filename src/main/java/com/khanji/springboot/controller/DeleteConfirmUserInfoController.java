package com.khanji.springboot.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
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
import com.khanji.springboot.service.DeleteUserInfoService;
import com.khanji.springboot.util.MessageUtil;

/**
 * ユーザ削除確認コントローラクラス
 *
 * @author khanji
 *
 */
@Controller
public class DeleteConfirmUserInfoController {

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private DeleteUserInfoService deleteUserInfoService;

    @RequestMapping(value = UrlConstant.URL_INIT_DELETE_CONFIRM_USERINFO, method = {GET, POST})
    public String initDeleteConfirmUserInfo(@ModelAttribute("userId") String userId, Model model) {
        model.addAttribute("user", this.deleteUserInfoService.getUserInfo(userId));
        return ViewConstant.VIEW_DELETE_USERINFO;
    }

    @RequestMapping(value = UrlConstant.URL_EXEC_DELETE_CONFIRM_USERINFO, method = POST)
    public String execDeleteUConfirmserInfo(@ModelAttribute("userId") String userId,
            RedirectAttributes redirectAttributes) {
        try {
            this.deleteUserInfoService.deleteUserInfo(userId);
            redirectAttributes.addFlashAttribute("info",
                    this.messageUtil.getMessage(WebMessagesConstant.APP_INFO_MSG_0003));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            redirectAttributes.addFlashAttribute("user",
                    this.deleteUserInfoService.getUserInfo(userId));
            return CommonConstant.COMMON_REDIRECT + UrlConstant.URL_INIT_DELETE_CONFIRM_USERINFO;
        }
        return CommonConstant.COMMON_REDIRECT + UrlConstant.URL_INIT_INDEX_USERINFO;
    }

}
