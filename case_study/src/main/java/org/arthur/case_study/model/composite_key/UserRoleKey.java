package org.arthur.case_study.model.composite_key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class UserRoleKey implements Serializable {
    @Column(name = "user_name")
    String userName;
    @Column(name ="role_Id")
    Long roleId;

    public UserRoleKey() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
