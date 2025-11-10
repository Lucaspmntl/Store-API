package com.selection.process.store.api.dto;

import com.selection.process.store.api.entity.Product;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Objects;

public class NewProductDTO {

    @NotBlank(message = "A descrição deve ser preenchida!")
    @Size(message = "A descrição deve ter entre 12 e 300 caracteres!", min = 12, max = 300)
    private String description;

    @NotNull(message = "O preço deve ser informado!")
    @Positive(message = "O valor deve ser positivo!")
    private BigDecimal price;

    @NotBlank(message = "O nome deve ser preenchido!")
    @Size(message = "O nome deve ter entre 5 e 100 caracteres", max = 100, min = 5)
    private String name;

    @NotNull(message = "A quantidade deve ser informada!")
    @Positive(message = "O valor deve ser positivo!")
    private Integer quantity;

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public NewProductDTO(){}

    public NewProductDTO(String description, BigDecimal price, String name, Integer quantity) {
        this.description = description;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public NewProductDTO(Product obj){
        this.quantity = obj.getQuantity();
        this.name = obj.getName();
        this.price = obj.getPrice();
        this.description = obj.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NewProductDTO that = (NewProductDTO) o;
        return quantity == that.quantity && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, name, quantity);
    }
}
