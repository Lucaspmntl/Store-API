package com.selection.process.store.api.dto;

import com.selection.process.store.api.entity.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDTO {

    private long id;

    @Min(message = "A descrição deve ter no mínimo 12 caracteres!", value = 12)
    private String description;

    @NotBlank(message = "O Valor deve ser preenchido!")
    @Positive(message = "O valor deve ser positivo!")
    private BigDecimal price;

    @NotBlank(message = "O nome deve ser preenchido!")
    private String name;

    @NotBlank(message = "O Valor deve ser preenchido!")
    @Positive(message = "O valor deve ser positivo!")
    private int quantity;

    public long getId() { return id; }
    // public void setId(long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public ProductDTO(){}

    public ProductDTO(long id, String description, BigDecimal price, String name, int quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public ProductDTO(Product obj){
        this.id = obj.getId();
        this.quantity = obj.getQuantity();
        this.name = obj.getName();
        this.price = obj.getPrice();
        this.description = obj.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
