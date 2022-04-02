package com.syscolabs.miniproject.entities;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private int qty;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String imgURL;

    @ManyToOne(
            targetEntity = Category.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    private Category category;
    @JsonBackReference(value = "category-product")
    public Category getCategory() {
        return category;
    }

    @ManyToOne(
            targetEntity = Producer.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    private Producer producer;
    @JsonBackReference
    public Producer getProducer() {
        return producer;
    }
}