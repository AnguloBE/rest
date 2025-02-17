package com.electronica.rest.infraestructure.abstract_services;

import com.electronica.rest.api.models.request.ProductoRequest;
import com.electronica.rest.api.models.responses.ProductoResponse;

import java.util.List;

public interface IProductoService extends CrudService<ProductoRequest, ProductoResponse, Long>{

    List<ProductoResponse> getAll();
}
