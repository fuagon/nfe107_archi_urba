package net.cnam.nfe107.domain;

import net.cnam.nfe107.controller.dto.ProductRequest;
import net.cnam.nfe107.controller.dto.ProductResponse;
import net.cnam.nfe107.domain.entity.Product;
import net.cnam.nfe107.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProductServiceUnit {

    @Autowired
    ProductService productService;

    /**
     * Ajouter du stock sur un produit
     * @param idProduct
     * @param stock
     */
    public void addStock(Long idProduct, Long stock) {
        Product product = productService.getById(idProduct);
        product.setStock(product.getStock() + stock);

        productService.update(product);
    }

    /**
     * Retirer du stock d'un produit
     * @param idProduct
     * @param stock
     */
    public void removeStock(Long idProduct, Long stock) {
        Product product = productService.getById(idProduct);
        product.setStock(product.getStock() - stock);

        productService.update(product);
    }
}