package com.selection.process.store.api.dto;

import com.selection.process.store.api.entity.Product;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductMaxDTO {

    private long id;
    private String description;
    private BigDecimal price;
    private String name;
    private int amount;

    public long getId() { return id; }
    // public void setId(long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public ProductMaxDTO(){}

    public ProductMaxDTO(long id, String description, BigDecimal price, String name, int amount) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.name = name;
        this.amount = amount;
    }

    public ProductMaxDTO(Product obj){
        this.id = obj.getId();
        this.amount = obj.getAmount();
        this.name = obj.getName();
        this.price = obj.getPrice();
        this.description = obj.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductMaxDTO that = (ProductMaxDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
