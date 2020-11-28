package net.cnam.nfe107.repository.model;

/*
 * @created 29/10/2020/10/2020 - 10:23
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @Column(name = "stock")
    private int stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, targetEntity = OrderProductModel.class)
    @Nullable
    private Set<OrderProductModel> ordersProducts = new HashSet<>();

    public ProductModel() {
    }

    public ProductModel(Long idProduct, String name, String description, float price, int stock, @Nullable Set<OrderProductModel> ordersProducts) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.ordersProducts = ordersProducts;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Nullable
    public Set<OrderProductModel> getOrdersProducts() {
        return ordersProducts;
    }

    public void setOrdersProducts(@Nullable Set<OrderProductModel> ordersProducts) {
        this.ordersProducts = ordersProducts;
    }
}
