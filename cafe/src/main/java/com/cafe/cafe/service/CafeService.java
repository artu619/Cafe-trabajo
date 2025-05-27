package com.cafe.cafe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cafe.cafe.model.Cafe;

public interface CafeService {
    Page<Cafe> getAllCafes(Pageable pageable);
    Cafe getCafeById(Long id);
    Cafe createCafe(Cafe cafe);
    Cafe updateCafe(Long id, Cafe cafe);
    void deleteCafe(Long id);
} 