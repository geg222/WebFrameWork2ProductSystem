package kr.ac.hansung.cse.hellospringdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;



@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String brand;
        private String madeIn;
        private double price;

        public Product() {}

        public Product(String name, String brand, String madeIn, double price) {
            this.name = name;
            this.brand = brand;
            this.madeIn = madeIn;
            this.price = price;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
