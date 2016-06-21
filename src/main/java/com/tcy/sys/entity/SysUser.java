package com.tcy.sys.entity;

import com.tcy.core.entity.LongPKEntity;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by 80002023 on 2016/6/3.
 */
@Entity
@Table(name = "SYS_USER")
@DynamicUpdate
@DynamicInsert
public class SysUser extends LongPKEntity {

    @Column(name = "USERNAME", unique = true, length = 20, nullable = false)
    private String username;

    @Column(name = "PASSWORD", length = 80)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXPIRES")
    private Date expires;
    @Column(name = "ENABLED")
    private Boolean enabled;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "SYS_USER_ROLE", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<SysRole> roles;


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


    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }


    public Boolean getEnabled() {
        if (enabled == null) {
            return false;
        }
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }
}
