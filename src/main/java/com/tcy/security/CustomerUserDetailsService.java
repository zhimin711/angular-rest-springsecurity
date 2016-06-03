package com.tcy.security;

import com.tcy.app.Constants;
import com.tcy.sys.entity.SysRole;
import com.tcy.sys.entity.SysUser;
import com.tcy.sys.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by 80002023 on 2016/6/3.
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("=>UserDetails auth {}", username);
        SysUser user = sysUserService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user with name " + username + " was not found!");
        }
        String password = user.getPassword();
        boolean enabled = user.getEnabled();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (SysRole role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(Constants.SECURITY_PREFFIX + role.getKey()));
        }
        return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
