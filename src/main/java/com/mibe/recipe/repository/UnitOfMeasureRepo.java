package com.mibe.recipe.repository;

import com.mibe.recipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepo extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByCode(String aCode);
}
