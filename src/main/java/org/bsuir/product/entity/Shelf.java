package org.bsuir.product.entity;

import java.util.List;

public interface Shelf {
    boolean addProduct(Product product);
    boolean addShelf(Shelf shelf);
    List<ProductType> getAvailableProductTypes();
    List<Product> getProducts();
    String getName();
}
