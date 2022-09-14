package com.springboot05ems.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author BoBooY
 * @date 2022/9/5 21:06
 */

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        Locale locale = Locale.getDefault();
        //如果请求不为空
        if(!StringUtils.isEmpty(lang)) {
            //分割请求参数
            String[] s = lang.split("_");
            //国家，地区
            locale = new Locale(s[0],s[1]);
        }
        return locale;

    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
