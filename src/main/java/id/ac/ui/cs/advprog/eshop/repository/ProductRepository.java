package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    public Product create(Product product) {
        product.setProductId(UUID.randomUUID().toString());
        productData.add(product);
        return product;
    }

<<<<<<< HEAD
    public Product edit(Product detail, String id) {
        Product product = getProduct(id);
        product.setProductName(detail.getProductName());
        product.setProductQuantity(detail.getProductQuantity());
        return detail;
=======
    public Product delete(String id) {
        Product product = getProduct(id);
        productData.remove(product);
        return product;
>>>>>>> delete-product
    }

    public Product getProduct(String id) {
        return productData.stream()
                .filter(t -> id.equals(t.getProductId()))
                .findFirst().orElse(null);
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}
