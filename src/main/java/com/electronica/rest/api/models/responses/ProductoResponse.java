package com.electronica.rest.api.models.responses;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoResponse {

    private Long productoId;

    private String nombre;

    private String identificador;

    private Integer unidadMedida;

    private String ubicacion;

    private BigDecimal costo;

    private BigDecimal PrecioAlPublico;

    private Integer cantidad;
}
