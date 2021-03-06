package com.discordapp.Model;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Role.
 */
public class Role implements Serializable {

    /**
     * The Permissions.
     */
    Permissions permissions;
    /**
     * The Role name.
     */
    String roleName;

    /**
     * Instantiates a new Role.
     *
     * @param roleName the role name
     */
    public Role(String roleName) {
        this.permissions = new Permissions();
        this.roleName = roleName;
        if (roleName.equals("owner")){
            permissions.setCAN_STRICT_CHANNEL(true);
            permissions.setCAN_SEE_HISTORY(true);
            permissions.setCAN_REMOVE_USER(true);
            permissions.setCAN_BAN_USER(true);
            permissions.setCAN_CREATE_CHANNEL(true);
            permissions.setCAN_PIN_MESSAGE(true);
            permissions.setCAN_CHANGE_SERVERNAME(true);
            permissions.setCAN_DELETE_CHANNEL(true);
        }
    }

    /**
     * Sets permissions.
     *
     * @param permissions the permissions
     */
    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    /**
     * Gets permissions.
     *
     * @return the permissions
     */
    public Permissions getPermissions() {
        return permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getPermissions(), role.getPermissions()) && Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPermissions(), roleName);
    }
}
