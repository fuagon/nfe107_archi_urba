package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.Product;
import net.cnam.nfe107.domain.entity.Product;
import net.cnam.nfe107.domain.entity.ProductToCreate;
import net.cnam.nfe107.repository.ProductRepository;
import net.cnam.nfe107.repository.model.ProductModel;
import net.cnam.nfe107.repository.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<ProductModel> productsFromModel = productRepository.findAll();
        ArrayList<Product> products = new ArrayList<>();

        for(ProductModel productModel: productsFromModel)
        {
            products.add(new Product(productModel));
        }

        return products;
    }

    public Product getById(Long idProduct) {
        ProductModel productModelFound = productRepository.getOne(idProduct);

        return new Product(productModelFound);
    }

    public Product create(ProductToCreate productToCreate)
    {
        ProductModel productModelToCreate = new ProductModel(productToCreate);

        ProductModel productModelCreated = productRepository.save(productModelToCreate);

        return new Product(productModelCreated);
    }

    public Product update(Product productToUpdate)
    {
        ProductModel productModel = new ProductModel(productToUpdate);

        ProductModel productModelUpdated = productRepository.save(productModel);

        return new Product(productModelUpdated);
    }

    public void delete(Long id)
    {
        productRepository.deleteById(id);
    }
}