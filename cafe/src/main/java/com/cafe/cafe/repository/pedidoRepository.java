// PedidoRepository.java
package com.cafe.cafe.repository;

import com.cafe.cafe.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
