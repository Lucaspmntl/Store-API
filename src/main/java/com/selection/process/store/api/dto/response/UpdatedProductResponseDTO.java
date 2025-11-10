package com.selection.process.store.api.dto.response;

import com.selection.process.store.api.dto.ProductDTO;
import com.selection.process.store.api.dto.UpdateProductDTO;


public class UpdatedProductResponseDTO {

    private String message;
    private ProductDTO product;
    private int Status;

    public UpdatedProductResponseDTO(){}
    public UpdatedProductResponseDTO(String message, ProductDTO product, int status) {
        this.message = message;
        this.product = product;
        Status = status;
    }

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public ProductDTO getProduct() {return product;}
    public void setProduct(ProductDTO product) {this.product = product;}

    public int getStatus() {return Status;}
    public void setStatus(int status) {Status = status;}
}
