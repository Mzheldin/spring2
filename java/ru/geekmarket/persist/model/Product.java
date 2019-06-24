package com.geekbrains.spring2.persist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name = "image")
    private String imagePath;

    @Column(name = "name")
    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "price")
    private double price;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    public Product() {
    }

    public Product(Category category, String imagePath, String name, String shortDescription, String fullDescription, double price, Date createAt) {
        this.category = category;
        this.imagePath = imagePath;
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.price = price;
        this.createAt = createAt;
    }
}
