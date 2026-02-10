package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
<<<<<<< HEAD
    public Product edit(Product detail, String id);
=======
    public Product delete(String id);
>>>>>>> delete-product
    public Product getProduct(String id);
    public List<Product> findAll();
}
