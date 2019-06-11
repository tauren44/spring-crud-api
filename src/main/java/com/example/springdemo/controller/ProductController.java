package com.example.springdemo.controller;

import com.example.springdemo.entity.ProductEntity;
import com.example.springdemo.mapper.dto.Producer;
import com.example.springdemo.mapper.dto.Product;
import com.example.springdemo.service.ProducerService;
import com.example.springdemo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.springdemo.util.DependencyCheckUtil.isProductOfThisProducer;

@RestController
@RequestMapping(path = "/producers/{producer_id}/products")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
    private final ProductService productService;
    private final ProducerService producerService;

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Product> createProduct(Product product,
                                                       @PathVariable(value = "producer_id") Long producerId) {
        product.setProducerId(producerId);
        productService.createProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * @param product entity which need to be updated
     * @param producerId producerId of this product
     * @param productId productId which need to be updated
     * @return HTTP status OK if product found and updated
     */
//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(path = "/{product_id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,
                                                       @PathVariable(value = "producer_id") Long producerId,
                                                       @PathVariable(value = "product_id") Long productId) {
        if (isProductOfThisProducer(producerId, producerService, productId, productService)) {
            productService.updateProduct(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * @param producerId target producerId from path
     * @return list of products for current producer
     */
    @GetMapping
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<Product> getAllProductsByProducer(@PathVariable(value = "producer_id") Long producerId) {
        Producer producer = producerService.findProducerById(producerId);
        return producer.getProducts();
    }

    /**
     * @param producerId target producerId from path
     * @param productId target productId from path
     * @param entity target product to delete
     * @return HTTP Status - OK if product is of this producer
     */
//    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(path = "/{product_id}")
    public ResponseEntity<ProductEntity> deleteProduct(@PathVariable(value = "producer_id") Long producerId,
                                                       @PathVariable(value = "product_id") Long productId,
                                                       ProductEntity entity) {
        if (isProductOfThisProducer(producerId, producerService, productId, productService)) {
            productService.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
    }

    /**
     * @param producerId target producerId from path
     * @param productId  target productId from path
     * @return responseBody with product if product is of this producer
     */
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{product_id}")
    public ResponseEntity<Product> getProductOfThisProducer(@PathVariable("producer_id") Long producerId,
                                                                  @PathVariable(value = "product_id") Long productId) {
        if (isProductOfThisProducer(producerId, producerService, productId, productService)) {
            Product product = productService.findProductById(productId);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
