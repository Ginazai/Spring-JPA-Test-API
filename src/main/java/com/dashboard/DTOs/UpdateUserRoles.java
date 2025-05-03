package com.dashboard.DTOs;

import java.util.Set;

public class UpdateUserRoles {
	private Set<String> role;
    public Set<String> getRoleNames() {
        return role;
    }
    public void setRoleNames(Set<String> role) {
        this.role = role;
    }
}
