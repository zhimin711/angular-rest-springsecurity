package com.tcy.sys.entity;

import com.tcy.core.entity.LongPKEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 80002023 on 2016/6/3.
 */
@Entity
@Table(name = "SYS_ROLE")
@DynamicUpdate
public class SysRole extends LongPKEntity{

    @Column(name = "ROLE_KEY", unique = true, length = 50)
    private String key;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<SysUser> users;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }
}
