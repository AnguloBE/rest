package com.electronica.rest.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity (name = "productos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;

    private String nombre;

    private String identificador;

    private Integer unidadMedida;

    private String ubicacion;

    private BigDecimal costo;

    private BigDecimal precioAlPublico;

    private Integer cantidad;

}
