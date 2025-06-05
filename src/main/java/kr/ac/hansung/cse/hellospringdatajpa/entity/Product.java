package kr.ac.hansung.cse.hellospringdatajpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "상품명을 입력해주세요.")
    @Size(min = 1, max = 100, message = "상품명은 1자 이상 100자 이하로 입력해주세요.")
    private String name;

    @NotNull(message = "브랜드를 입력해주세요.")
    @Size(min = 1, max = 50, message = "브랜드는 1자 이상 50자 이하로 입력해주세요.")
    private String brand;

    @NotNull(message = "원산지를 입력해주세요.")
    @Pattern(regexp = "^[가-힣a-zA-Z\\s]+$", message = "원산지는 문자만 입력 가능합니다.")
    private String madeIn;

    @NotNull(message = "가격을 입력해주세요.")
    @Min(value = 1, message = "가격은 1 이상이어야 합니다.")
    private double price;

    public Product(String name, String brand, String madeIn, double price) {
        this.name = name;
        this.brand = brand;
        this.madeIn = madeIn;
        this.price = price;
    }
}