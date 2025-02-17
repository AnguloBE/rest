package com.electronica.rest.api.controllers;

import com.electronica.rest.api.models.request.ProductoRequest;
import com.electronica.rest.api.models.responses.ProductoResponse;
import com.electronica.rest.infraestructure.abstract_services.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "producto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductoController {

    private final IProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoResponse> post(@RequestBody ProductoRequest request) {

        return ResponseEntity.ok(productoService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> get(@PathVariable Long id) {

        return ResponseEntity.ok(productoService.read(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> getAll() {
        return ResponseEntity.ok(productoService.getAll());

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> put(@RequestBody ProductoRequest request, @PathVariable Long id) {

        return ResponseEntity.ok(productoService.update(request,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        this.productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
