package com.olvrslab.hoxieapi.auth.controllers.requests;

public record UserDataInput(
        String fullName,
        String username,
        String password,
        boolean enabled,
        String roleName
) {
}

