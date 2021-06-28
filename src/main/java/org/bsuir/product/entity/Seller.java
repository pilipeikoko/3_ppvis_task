package org.bsuir.product.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface Seller {
    Product createAndAddProductOnShelf(String name, ProductType productType, LocalDate expirationDate,Shelf shelf);
    Map<List<Product>,Shelf> searchProductsByName(String name);
    List<Product> findExpiredProducts();
}
