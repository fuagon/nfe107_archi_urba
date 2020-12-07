package net.cnam.nfe107.repository.model;

import com.sun.istack.Nullable;
import net.cnam.nfe107.domain.entity.Product;
import net.cnam.nfe107.domain.entity.ProductToCreate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="table_product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "stock")
    private Long stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, targetEntity = OrderProductModel.class)
    @Nullable
    private Set<OrderProductModel> ordersProducts = new HashSet<>();

    public ProductModel() {
    }

    public ProductModel(Long idProduct, String name, String description, Float price, Long stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public ProductModel(Product product) {
        this.idProduct = product.getIdProduct();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

    public ProductModel(ProductToCreate productToCreate) {
        this.name = productToCreate.getName();
        this.description = productToCreate.getDescription();
        this.price = productToCreate.getPrice();
        this.stock = productToCreate.getStock();
    }

    public Long getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    @Nullable
    public Set<OrderProductModel> getOrders() {
        return ordersProducts;
    }
    public void setOrders(@Nullable Set<OrderProductModel> ordersProducts) {
        this.ordersProducts = ordersProducts;
    }
    public Long getStock() {
        return stock;
    }
    public void setStock(Long stock) {
        this.stock = stock;
    }
}