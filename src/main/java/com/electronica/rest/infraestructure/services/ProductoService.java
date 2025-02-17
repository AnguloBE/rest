package com.electronica.rest.infraestructure.services;

import com.electronica.rest.api.models.request.ProductoRequest;
import com.electronica.rest.api.models.responses.ProductoResponse;
import com.electronica.rest.domain.entities.Producto;
import com.electronica.rest.domain.repositories.ProductoRepository;
import com.electronica.rest.infraestructure.abstract_services.IProductoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class ProductoService implements IProductoService {

    private final ProductoRepository productoRepository;


    @Override
    public ProductoResponse create(ProductoRequest request) {

        var productoAGuardar = new Producto();

        BeanUtils.copyProperties(request,productoAGuardar);
        var productoGuardado = this.productoRepository.save(productoAGuardar);

        var productoResponse = new ProductoResponse();

        BeanUtils.copyProperties(productoGuardado,productoResponse);

        log.info("Producto guardado con el id: {}", productoGuardado.getProductoId());

        return productoResponse;
    }

    @Override
    public ProductoResponse read(Long id) {
        var producto = this.productoRepository.findById(id).orElseThrow();

        var productoResponse = new ProductoResponse();

        BeanUtils.copyProperties(producto,productoResponse);

        return productoResponse;
    }



    @Override
    public ProductoResponse update(ProductoRequest request, Long id) {

        var productoAActualizar = this.productoRepository.findById(id).orElseThrow();
        productoAActualizar.setNombre(request.getNombre());
        productoAActualizar.setIdentificador(request.getIdentificador());
        productoAActualizar.setUnidadMedida(request.getUnidadMedida());
        productoAActualizar.setUbicacion(request.getUbicacion());
        productoAActualizar.setCosto(request.getCosto());
        productoAActualizar.setPrecioAlPublico(request.getPrecioAlPublico());
        productoAActualizar.setCantidad(request.getCantidad());



        var productoActualizado = this.productoRepository.save(productoAActualizar);

        var productoResponse = new ProductoResponse();
        BeanUtils.copyProperties(productoActualizado, productoResponse);
        return productoResponse;
    }

    @Override
    public void delete(Long id) {

        var productoAEliminar = this.productoRepository.findById(id).orElseThrow();
        this.productoRepository.delete(productoAEliminar);
    }


    @Override
    public List<ProductoResponse> getAll() {
        List<Producto> productos = this.productoRepository.findAll();
        return productToResponse(productos);
    }


    public List<ProductoResponse> productToResponse(List<Producto> productos){
        var productosResponse= new ArrayList<ProductoResponse>();
        var productoTransaccion = new ProductoResponse();

        for (Producto producto : productos) {
            BeanUtils.copyProperties(producto,productoTransaccion);
            productosResponse.add(productoTransaccion);
            productoTransaccion = new ProductoResponse();
        }
        return productosResponse;
    }
}
