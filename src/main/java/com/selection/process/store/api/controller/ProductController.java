package com.selection.process.store.api.controller;

import com.selection.process.store.api.dto.NewProductDTO;
import com.selection.process.store.api.dto.response.GenericIdResponseDTO;
import com.selection.process.store.api.dto.response.GenericResponseDTO;
import com.selection.process.store.api.dto.ProductDTO;
import com.selection.process.store.api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO> dto = productService.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable long id){
        ProductDTO dto = productService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<GenericIdResponseDTO> registerProduct(@Valid @RequestBody NewProductDTO dto){
        ProductDTO registeredProduct = productService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new GenericIdResponseDTO("Produto registrado com sucesso!", registeredProduct.getId(), 201));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<GenericResponseDTO> updateProduct(@RequestBody ProductDTO dto){
        return null;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<ProductDTO> search(@RequestParam String partialName){
        return null;
    }


}