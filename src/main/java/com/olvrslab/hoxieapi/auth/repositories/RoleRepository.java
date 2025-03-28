package com.olvrslab.hoxieapi.auth.repositories;

import com.olvrslab.hoxieapi.auth.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
