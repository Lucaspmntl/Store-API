package com.selection.process.store.api.entity;

import com.selection.process.store.api.dto.NewProductDTO;
import com.selection.process.store.api.dto.ProductDTO;
import jakarta.persistence.*;

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
    private int quantity;

    public Product(){}

    public Product(long id, String description, BigDecimal price, String name, int quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public Product(NewProductDTO dto){
        this.quantity = dto.getQuantity();
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.description = dto.getDescription();
    }

    public Product(ProductDTO dto){
        this.id = dto.getId();
        this.quantity = dto.getQuantity();
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

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && quantity == product.quantity && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, quantity);
    }
}
