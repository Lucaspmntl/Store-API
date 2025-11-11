package com.selection.process.store.api.controller;

import com.selection.process.store.api.dto.ProductMinDTO;
import com.selection.process.store.api.dto.UpdateProductDTO;
import com.selection.process.store.api.dto.response.GenericIdResponseDTO;
import com.selection.process.store.api.dto.ProductDTO;
import com.selection.process.store.api.dto.response.GenericResponseDTO;
import com.selection.process.store.api.dto.response.UpdatedProductResponseDTO;
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
    public ResponseEntity<List<ProductDTO>> findAll(@RequestParam (required = false) String name){
        if (name == null || name.isBlank() || name.trim().isBlank()){
            List<ProductDTO> dto = productService.findAll();
            return ResponseEntity.ok(dto);
        }

        List<ProductDTO> partialNameProducts = productService.searchByPartialName(name);
        return ResponseEntity.ok(partialNameProducts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable long id){
        ProductDTO dto = productService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<GenericIdResponseDTO> registerProduct(@Valid @RequestBody ProductMinDTO dto){
        ProductDTO registeredProduct = productService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new GenericIdResponseDTO("Produto registrado com sucesso!", registeredProduct.getId(), 201));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UpdatedProductResponseDTO> updateProduct(
            @Valid
            @PathVariable long id,
            @Valid @RequestBody UpdateProductDTO dto){

        ProductDTO updatedProductDTO = productService.update(dto, id);

        return ResponseEntity.ok(new UpdatedProductResponseDTO(
                "Produto atualizado com sucesso!",
                updatedProductDTO,
                HttpStatus.OK.value()
        ));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<GenericResponseDTO> deleteById(@PathVariable long id){
        ProductDTO deletedProduct = productService.deleteById(id);
        return ResponseEntity.ok(
                new GenericResponseDTO(
                        deletedProduct.getName() + " excluído com sucesso!",
                        200));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<ProductDTO> search(@RequestParam String partialName){
        return null;
    }


}