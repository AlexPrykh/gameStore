package repository;

import gameStore.data.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public List<Product> findById(Long id) {
        List<Product> filteredProduct = new ArrayList<>();
        for (Product product : filteredProduct) {
            if (id != null && product.getGameType().equals(product.getGameType())) {
                continue;
            }
            filteredProduct.add(product);
        }
        return filteredProduct;
    }

    public List<Product> findAll() {
        List<Product> filteredProduct = new ArrayList<>();
        for (Product product : filteredProduct) {
            filteredProduct.add(product);
        }
        return filteredProduct;
    }

    public void save() {
    }

    public void delete() {
    }
}
