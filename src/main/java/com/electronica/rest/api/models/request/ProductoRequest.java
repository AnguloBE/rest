package com.electronica.rest.api.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoRequest {

    private String nombre;

    private String identificador;

    private Integer unidadMedida;

    private String ubicacion;

    private BigDecimal costo;

    private BigDecimal precioAlPublico;

    private Integer cantidad;
}
