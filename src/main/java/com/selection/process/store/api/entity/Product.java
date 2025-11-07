package com.selection.process.store.api.entity;

import com.selection.process.store.api.dto.ProductMaxDTO;
import jakarta.persistence.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private BigDecimal price;

    private String name;
    private int amount;

    public Product(){}

    public Product(long id, String description, BigDecimal price, String name, int amount) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.name = name;
        this.amount = amount;
    }

    public Product(ProductMaxDTO dto){
        this.id = dto.getId();
        this.amount = dto.getAmount();
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.description = dto.getDescription();
    }

    public long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && amount == product.amount && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, amount);
    }
}
