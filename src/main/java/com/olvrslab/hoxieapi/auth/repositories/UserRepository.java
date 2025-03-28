package com.olvrslab.hoxieapi.auth.repositories;

import com.olvrslab.hoxieapi.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
