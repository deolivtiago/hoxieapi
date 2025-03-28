package com.olvrslab.hoxieapi.auth.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Transient
    private Type type;

    enum Type {
        USER, ADMIN
    }

    @Id
    @Builder.Default
    private String authority = String.join("ROLE:", Type.USER.name());

    @Builder.Default
    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions = new HashSet<>();

}
