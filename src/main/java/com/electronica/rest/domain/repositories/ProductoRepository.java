package com.electronica.rest.domain.repositories;

import com.electronica.rest.domain.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
