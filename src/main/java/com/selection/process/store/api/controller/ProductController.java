package com.selection.process.store.api.controller;

import com.selection.process.store.api.dto.GenericIdResponseDTO;
import com.selection.process.store.api.dto.GenericResponseDTO;
import com.selection.process.store.api.dto.ProductDTO;
import com.selection.process.store.api.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
        return null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable long id){
        return null;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<GenericIdResponseDTO> registerProduct(@RequestBody ProductDTO dto){
        return null;
    }

    @PutMapping(value = "/update")
    public ResponseEntity<GenericResponseDTO> updateProduct(@RequestBody ProductDTO dto){
        return null;
    }

    @GetMapping
    public ResponseEntity<ProductDTO> search(@RequestParam String partialName){
        return null;
    }


}
