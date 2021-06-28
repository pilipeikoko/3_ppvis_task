package org.bsuir.product.entity.impl;

import org.bsuir.product.entity.Product;
import org.bsuir.product.entity.ProductType;
import org.bsuir.product.entity.Seller;
import org.bsuir.product.entity.Shelf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerImpl implements Seller {
    @Override
    public synchronized Product createAndAddProductOnShelf(String name, ProductType productType, LocalDate expirationDate, Shelf shelf) {
        return new Product(shelf,name,productType,expirationDate);
    }

    @Override
    public synchronized Map<List<Product>, Shelf> searchProductsByName(String name) {
        List<Shelf> shelves = ShelfImpl.getShelves();
        Map<List<Product>, Shelf> result = new HashMap<>();

        for (Shelf shelf : shelves) {
            List<Product> products = shelf.getProducts();
            List<Product> currentShelfList = new ArrayList<>();

            for (Product product : products) {
                if (product.getExpirationDate().compareTo(LocalDate.now()) < 0) {
                    currentShelfList.add(product);
                }
            }

            if (!currentShelfList.isEmpty()) {
                result.put(currentShelfList, shelf);
            }
        }
        return result;
    }

    @Override
    public synchronized List<Product> findExpiredProducts() {
        List<Shelf> shelves = ShelfImpl.getShelves();
        List<Product> result = new ArrayList<>();

        for (Shelf shelf : shelves) {
            List<Product> products = shelf.getProducts();

            for (Product product : products) {
                if (product.getExpirationDate().compareTo(LocalDate.now()) < 0) {
                    result.add(product);
                }
            }
        }

        return result;
    }
}
