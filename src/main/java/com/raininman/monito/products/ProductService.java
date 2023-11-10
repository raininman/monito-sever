package com.raininman.monito.products;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> petItemByTitle = productRepository.findPetItemByTitle(product.getTitle());
        if (petItemByTitle.isPresent()) {
            throw new IllegalStateException("Title taken");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        boolean exists = productRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Id " + id + " not found");

        }
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(Long id, String title, String description, List<String> imgs) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalStateException("Id " + id + " not found"));
        if (title != null && title.length() > 0) {
            product.setTitle(title);
        }
        if (description != null && description.length() > 0) {
            product.setDescription(description);
        }

        if (imgs != null && imgs.size() > 0) {
            product.setImgs(imgs);
        }


    }
}
