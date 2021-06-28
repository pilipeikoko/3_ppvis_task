package org.bsuir.product.entity;

import java.util.List;

public interface Manager {
    Shelf createNewShelf(String name);
    boolean removeShelf(String name);
    List<Product> findExpiredProducts();
    List<Product> findProductsByType(ProductType productType);

}
