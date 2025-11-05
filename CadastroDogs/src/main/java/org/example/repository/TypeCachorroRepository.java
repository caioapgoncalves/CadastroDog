package org.example.repository;

import org.example.model.TypeCachorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCachorroRepository extends JpaRepository<TypeCachorro, Integer> {
}
