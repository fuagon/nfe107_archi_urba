package net.cnam.nfe107.repository;

import net.cnam.nfe107.repository.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <ProductModel, Long> {
}
