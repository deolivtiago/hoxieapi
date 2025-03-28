package com.olvrslab.hoxieapi.auth.controllers.requests;

import com.olvrslab.hoxieapi.auth.domain.Permission;

import java.util.Set;

public record RoleInput(String authority, Set<Permission> permissions) {
}
