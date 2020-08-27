package com.amarod.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amarod.model.KeyValues;

public interface KeyValueRepository extends JpaRepository<KeyValues, Integer> {

}
