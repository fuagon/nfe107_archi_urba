package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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