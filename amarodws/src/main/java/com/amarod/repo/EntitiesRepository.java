package com.amarod.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amarod.model.Entities;

public interface EntitiesRepository extends JpaRepository<Entities, Integer> {

}
