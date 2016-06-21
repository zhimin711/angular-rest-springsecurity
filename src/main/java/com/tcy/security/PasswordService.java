package com.tcy.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by 80002023 on 2016/6/21.
 */
public class PasswordService extends org.apache.shiro.authc.credential.DefaultPasswordService implements PasswordEncoder {


    @Override
    public String encode(CharSequence charSequence) {
        return this.encryptPassword(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return this.passwordsMatch(charSequence, s);
    }
}
