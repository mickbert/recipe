package com.mibe.recipe.repository;

import com.mibe.recipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<Long, UnitOfMeasure> {
    Optional<UnitOfMeasure> findByCode(String aCode);
}
