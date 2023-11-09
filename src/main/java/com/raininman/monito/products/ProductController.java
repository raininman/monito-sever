package com.raininman.monito.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public void postProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{petItemId}")
    public void deleteProduct(@PathVariable("petItemId") Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping(path = "{petItemId}")
    public void updateProduct(
            @PathVariable("petItemId") Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) List<String> imgs
    ) {
        productService.updateProduct(id, title, description, imgs);
    }
}
