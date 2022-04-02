package com.syscolabs.miniproject.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {

    @Id
    private String name;

    @NonNull
    private String imgURL;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "category",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Product> products;

    @JsonManagedReference(value = "category-product")
    public List<Product> getProducts() {
        return products;
    }
}