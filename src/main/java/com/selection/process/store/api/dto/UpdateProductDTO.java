package com.selection.process.store.api.dto;


import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class UpdateProductDTO {

    @Size(message = "A descrição deve ter entre 12 e 300 caracteres!", min = 12, max = 300)
    private String description;

    @Positive(message = "O valor deve ser positivo!")
    private BigDecimal price;

    @Size(message = "O nome deve ter entre 5 e 100 caracteres", max = 100, min = 5)
    private String name;

    @Positive(message = "O valor deve ser positivo!")
    private Integer quantity;

    public UpdateProductDTO(){}
    public UpdateProductDTO(String description, BigDecimal price, String name, int quantity) {
        this.description = description;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Integer getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
}
