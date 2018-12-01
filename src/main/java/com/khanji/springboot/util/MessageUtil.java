package com.khanji.springboot.util;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

/**
 * メッセージユーティリティクラス
 * 
 * @author khanji
 *
 */
@Component
@Getter
@Setter
public class MessageUtil {

    @Value("${spring.messages.basename}")
    private String baseName;

    private String encoding = StandardCharsets.UTF_8.name();
    private Locale locale = Locale.getDefault();
    private static volatile MessageSource messageSource;

    /**
     * message.propertiesよりメッセージリソースの値を取得する
     *
     * @param code メッセージコード
     * @param args メッセージ痴漢文字列配列
     * @return メッセージ
     */
    public String getMessage(String code, Object... args) {
        return getMessageSource().getMessage(code, args, getLocale());
    }

    /**
     * メッセージ取得用インスタンスを返却する
     *
     * @return MessageSource インスタンス
     */
    private MessageSource getMessageSource() {
        MessageSource ms = messageSource;
        if (ms == null) {
            synchronized (MessageUtil.class) {
                ms = messageSource;
                if (ms == null) {
                    ms = messageSource = createMessageSource();
                }
            }
        }
        return ms;
    }

    /**
     * MessageSourceを生成し返却する
     *
     * @return MessageSource インスタンス
     */
    private MessageSource createMessageSource() {
        ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
        rbms.setBasename(getBaseName());
        rbms.setDefaultEncoding(getEncoding());
        return rbms;
    }

    public MessageUtil() {}

}
