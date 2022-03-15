package com.syscolabs.miniproject.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "category",
            fetch = FetchType.LAZY
    )
    private List<Product> products;

    @JsonManagedReference
    public List<Product> getProducts() {
        return products;
    }
}