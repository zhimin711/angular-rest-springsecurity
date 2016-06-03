package com.tcy.sys.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 80002023 on 2016/6/3.
 */
@Entity
@Table(name = "SYS_ROLE")
@DynamicUpdate
public class SysRole {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;
    @Column(name = "ROLE_KEY", unique = true, length = 50)
    private String key;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;
    @Column(name = "ENABLED")
    private Boolean enabled;
    @Column(name = "IS_SYS")
    private Boolean isSys;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<SysUser> users;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getSys() {
        return isSys;
    }

    public void setSys(Boolean sys) {
        isSys = sys;
    }

    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }
}
