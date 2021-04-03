package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.Product;
import net.cnam.nfe107.domain.entity.crud.ProductService;
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
    public boolean addStock(Long idProduct, Long stock) {
        Product product = productService.getById(idProduct);
        product.setStock(product.getStock() + stock);

        productService.update(product);
        return true;
    }

    /**
     * Retirer du stock d'un produit
     * @param idProduct
     * @param quantite
     */
    public boolean removeStock(Long idProduct, Long quantite) {
        Product product = productService.getById(idProduct);

        // On test si c'est possible de retier la quantité demandé
        if(!(product.getStock() - quantite < 0)){
            product.setStock(product.getStock() - quantite);
            productService.update(product);
            return true;
        }
        return false;
    }
}