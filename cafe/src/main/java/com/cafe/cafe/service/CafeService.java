package com.cafe.cafe.service;

import java.util.List;

import com.cafe.cafe.model.Cafe;

public interface CafeService {
    List<Cafe> getAllCafes();
    Cafe getCafeById(Long id);
    Cafe createCafe(Cafe cafe);
    Cafe updateCafe(Long id, Cafe cafe);
    void deleteCafe(Long id);
} 