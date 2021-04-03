package net.cnam.nfe107.controller.crud;

import net.cnam.nfe107.controller.dto.ProductRequest;
import net.cnam.nfe107.controller.dto.ProductResponse;
import net.cnam.nfe107.domain.entity.crud.ProductService;
import net.cnam.nfe107.domain.entity.Product;
import net.cnam.nfe107.domain.entity.ProductToCreate;
import net.cnam.nfe107.repository.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAllProducts")
    @ResponseBody
    public ResponseEntity<ArrayList<ProductResponse>> getAllProducts() {

        List<ProductModel> productFound = productService.getAllProducts();
        ArrayList<ProductResponse> productsResponse = new ArrayList<>();

        for (ProductModel product:productFound) {
            ProductResponse product1 = new ProductResponse(product);
            productsResponse.add(product1);
        }

        return new ResponseEntity<>(productsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long id) {
        Product productFound = productService.getById(id);

        ProductResponse productResponse = new ProductResponse(productFound);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductToCreate productToCreate = new ProductToCreate(productRequest);

        Product productCreated = productService.create(productToCreate);

        ProductResponse productResponse = new ProductResponse(productCreated);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody ProductRequest productRequest)
    {
        Product productToUpdate = new Product(productRequest);

        Product productUpdated = productService.update(productToUpdate);

        ProductResponse productResponse = new ProductResponse(productUpdated);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable("id") Long id)
    {
        productService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}