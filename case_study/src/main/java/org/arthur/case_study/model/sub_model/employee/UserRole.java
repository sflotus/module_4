package org.arthur.case_study.model.sub_model.employee;

import jakarta.persistence.*;
import org.arthur.case_study.model.composite_key.UserRoleKey;

@Entity
public class UserRole {
    @EmbeddedId
    private UserRoleKey id;
    @ManyToOne
    @MapsId("userName")
    @JoinColumn(name = "user_name")
    private User user;
    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;

    public UserRole() {
    }

    public UserRoleKey getId() {
        return id;
    }

    public void setId(UserRoleKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
