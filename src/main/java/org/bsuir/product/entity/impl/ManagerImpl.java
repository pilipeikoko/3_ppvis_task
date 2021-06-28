package org.bsuir.product.entity.impl;

import org.bsuir.product.entity.Manager;
import org.bsuir.product.entity.Product;
import org.bsuir.product.entity.ProductType;
import org.bsuir.product.entity.Shelf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerImpl implements Manager {
    @Override
    public Shelf createNewShelf(String name) {
        return new ShelfImpl(name);
    }

    @Override
    public boolean removeShelf(String name) {
        List<Shelf> shelves = new ArrayList<>(ShelfImpl.getShelves());

        return shelves.removeIf(shelf -> shelf.getName().equals(name));
    }

    @Override
    public List<Product> findExpiredProducts() {
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

    @Override
    public List<Product> findProductsByType(ProductType productType) {
        List<Shelf> shelves = ShelfImpl.getShelves();
        List<Product> result = new ArrayList<>();

        for (Shelf shelf : shelves) {
            List<Product> products = shelf.getProducts();
            for (Product product : products) {
                if (product.getProductType().equals(productType)) {
                    result.add(product);
                }
            }
        }
        return result;
    }
}
