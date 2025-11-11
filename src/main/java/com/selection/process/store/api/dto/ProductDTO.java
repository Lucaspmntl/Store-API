package com.selection.process.store.api.dto;

import com.selection.process.store.api.entity.Product;
import com.selection.process.store.api.projection.ProductProjection;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDTO {

    private long id;

    @NotBlank(message = "A descrição deve ser preenchida!")
    @Size(message = "A descrição deve ter entre 12 e 300 caracteres!", min = 12, max = 300)
    private String description;

    @NotBlank(message = "O Valor deve ser preenchido!")
    @Positive(message = "O valor deve ser positivo!")
    private BigDecimal price;

    @NotBlank(message = "O nome deve ser preenchido!")
    @Size(message = "O nome deve ter entre 5 e 100 caracteres", max = 100, min = 5)
    private String name;

    @NotNull(message = "O Valor deve ser preenchido!")
    @Positive(message = "O valor deve ser positivo!")
    private Integer quantity;

    public long getId() { return id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public ProductDTO(){}
    public ProductDTO(long id, String description, BigDecimal price, String name, Integer quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }
    public ProductDTO(ProductProjection projection){
        this.id = projection.getId();
        this.description = projection.getDescription();
        this.price = projection.getPrice();
        this.name = projection.getName();
        this.quantity = projection.getQuantity();
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
