package com.olvrslab.hoxieapi.auth.repositories;

import com.olvrslab.hoxieapi.auth.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
}
