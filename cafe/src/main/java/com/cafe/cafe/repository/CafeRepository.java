package com.cafe.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.cafe.model.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long> {
} 