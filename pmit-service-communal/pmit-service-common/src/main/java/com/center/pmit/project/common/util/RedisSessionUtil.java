package com.center.pmit.project.common.util;

import com.center.pmit.project.common.exception.UserNotExistException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 判断用户Session是否过期
 *
 * @author Administrator
 */
public class RedisSessionUtil {

    public static HttpSession checkUserAccountIsSession(HttpServletRequest request) {

            HttpSession session = request.getSession(false);
            Object userAccount = session.getAttribute("userAccount");
            if (userAccount == null) {
                throw new RuntimeException("异常");
            }
            return session;


    }
}
