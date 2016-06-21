package com.tcy.security;

import com.tcy.sys.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by 80002023 on 2016/6/21.
 */
public class SecurityUtils {

    private final static Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

    public static SysUser currentUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();

        logger.info("current user principal {}", principal);
        if (principal instanceof String && ((String) principal).equals("anonymousUser")) {
            return null;
        }

        UserDetails userDetails = (UserDetails) principal;

        logger.info("Current username {}", userDetails.getUsername());

        return null;
    }

    public static String getCurrentUsername() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof String && ((String) principal).equals("anonymousUser")) {
            return null;
        }
        return ((UserDetails) principal).getUsername();
    }

    public static SecurityContext getSecurityContext() throws Exception {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            throw new Exception("Web application security not start.");
        }
        return context;
    }

    public static Authentication getAuthentication() {
        try {
            return getSecurityContext().getAuthentication();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
