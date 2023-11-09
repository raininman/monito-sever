package com.raininman.monito.products;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "products_sequence",
            sequenceName = "products_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "products_sequence"
    )
    private Long id;
    private String title;
    private String description;
    private String price;
    private List<String> imgs;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", imgs=" + imgs +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public Product() {
    }

    public Product(String title, String description, String price, List<String> imgs) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imgs = imgs;
    }

    public Product(Long id, String title, String description, String price, List<String> imgs) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imgs = imgs;
    }
}
