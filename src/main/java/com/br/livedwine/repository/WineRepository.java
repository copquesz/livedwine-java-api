package com.br.livedwine.repository;

import com.br.livedwine.model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Lucas Copque
 * @version 1.0
 * @since 06/11/2019
 */
@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {

    Optional<Wine> findByNameLike(String name);
}
