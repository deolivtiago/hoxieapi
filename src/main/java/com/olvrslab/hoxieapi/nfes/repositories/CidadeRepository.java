package com.olvrslab.hoxieapi.nfes.repositories;

import com.olvrslab.hoxieapi.nfes.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<City, Integer> {
}
