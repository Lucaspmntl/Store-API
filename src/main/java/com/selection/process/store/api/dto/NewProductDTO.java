package com.selection.process.store.api.dto;

import com.selection.process.store.api.entity.Product;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Objects;

public class NewProductDTO {

    @NotBlank(message = "A descrição deve ser preenchida!")
    @Size(min = 12, message = "A descrição deve conter ao menos 12 caracteres!")
    private String description;

    @NotNull(message = "O preço deve ser informado!")
    @Positive(message = "O valor deve ser positivo!")
    private BigDecimal price;

    @NotBlank(message = "O nome deve ser preenchido!")
    private String name;

    @NotNull(message = "A quantidade deve ser informada!")
    @Positive(message = "O valor deve ser positivo!")
    private int quantity;

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public NewProductDTO(){}

    public NewProductDTO(String description, BigDecimal price, String name, int quantity) {
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
