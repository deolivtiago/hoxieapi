package com.olvrslab.hoxieapi.auth.controllers;

import com.olvrslab.hoxieapi.auth.controllers.requests.PermissionInput;
import com.olvrslab.hoxieapi.auth.controllers.requests.RoleInput;
import com.olvrslab.hoxieapi.auth.controllers.requests.UserDataInput;
import com.olvrslab.hoxieapi.auth.domain.Permission;
import com.olvrslab.hoxieapi.auth.domain.Role;
import com.olvrslab.hoxieapi.auth.domain.User;
import com.olvrslab.hoxieapi.auth.repositories.PermissionRepository;
import com.olvrslab.hoxieapi.auth.repositories.RoleRepository;
import com.olvrslab.hoxieapi.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDataInput input) {
        System.out.println(input.toString());
        final var permission = Permission.builder().authority("READ_PERMISSION").build();
        final var role = Role.builder().authority("ROLE_USER").permissions(Set.of(permission)).build();

        final var entity = User.builder()
                .fullName(input.fullName())
                .username(input.username())
                .password(input.password())
                .enabled(input.enabled())
                .build();

        final var output = userRepository.save(entity);

        System.out.println(output.toString());

        return ResponseEntity.ok(output);
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody RoleInput input) {
        final var entity = Role.builder()
                .authority(input.authority())
                .permissions(input.permissions())
                .build();

        final var output = roleRepository.save(entity);

        return ResponseEntity.ok(output);
    }

    @PostMapping("/permissions")
    public ResponseEntity<Permission> createPermission(@RequestBody PermissionInput input) {
        final var entity = Permission.builder()
                .authority(input.authority())
                .build();

        final var output = permissionRepository.save(entity);

        return ResponseEntity.ok(output);
    }
}
