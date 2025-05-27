package com.cafe.cafe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe.cafe.model.Cafe;
import com.cafe.cafe.repository.CafeRepository;
import com.cafe.cafe.service.CafeService;

@Service
@Transactional
public class CafeServiceImpl implements CafeService {

    @Autowired
    private CafeRepository cafeRepository;

    @Override
    public Page<Cafe> getAllCafes(Pageable pageable) {
        return cafeRepository.findAll(pageable);
    }

    @Override
    public Cafe getCafeById(Long id) {
        return cafeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Café no encontrado con id: " + id));
    }

    @Override
    public Cafe createCafe(Cafe cafe) {
        if (cafe.getNombre() == null || cafe.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del café no puede estar vacío");
        }
        if (cafe.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio del café debe ser mayor que cero");
        }
        return cafeRepository.save(cafe);
    }

    @Override
    public Cafe updateCafe(Long id, Cafe cafe) {
        Cafe existingCafe = getCafeById(id);
        
        if (cafe.getNombre() != null && !cafe.getNombre().trim().isEmpty()) {
            existingCafe.setNombre(cafe.getNombre());
        }
        if (cafe.getPrecio() > 0) {
            existingCafe.setPrecio(cafe.getPrecio());
        }
        if (cafe.getOrigen() != null) {
            existingCafe.setOrigen(cafe.getOrigen());
        }
        
        return cafeRepository.save(existingCafe);
    }

    @Override
    public void deleteCafe(Long id) {
        if (!cafeRepository.existsById(id)) {
            throw new RuntimeException("Café no encontrado con id: " + id);
        }
        cafeRepository.deleteById(id);
    }
} 