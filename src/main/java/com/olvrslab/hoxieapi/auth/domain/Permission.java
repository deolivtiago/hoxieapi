package com.olvrslab.hoxieapi.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "permissions")
public class Permission implements GrantedAuthority {

    @Id
    private String authority;

    public enum Resource {
        USERS
    }

    public enum Type {
        READ, DELETE
    }

    public Permission(Resource resource, Type type) {
        this.authority = String.join(":", resource.name(), type.name());
    }

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();
}
