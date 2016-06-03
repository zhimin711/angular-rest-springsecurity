package com.tcy.sys.entity;

import net.dontdrinkandroot.example.angularrestspringsecurity.entity.Role;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 80002023 on 2016/6/3.
 */
@Entity
@Table(name = "SYS_USER")
@DynamicUpdate
public class SysUser {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME",unique = true, length = 20, nullable = false)
    private String username;

    @Column(name = "PASSWORD",length = 80, nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<Role>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
