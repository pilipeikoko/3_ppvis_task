package org.bsuir.product.entity.impl;

import org.bsuir.product.exception.CustomException;
import org.bsuir.product.entity.Product;
import org.bsuir.product.entity.ProductType;
import org.bsuir.product.entity.Shelf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.bsuir.product.validator.ShelfValidator.isProductAvailable;

public class ShelfImpl implements Shelf {
    private static final List<Shelf> shelves;

    private final List<ProductType> availableProductTypes;
    private final List<Product> products;

    private String name;

    static {
        shelves = new LinkedList<>();
    }

    {
        availableProductTypes = new ArrayList<>();
        products = new ArrayList<>();
    }

    public ShelfImpl(){

    }
    public ShelfImpl(String name){
        this.name = name;
    }


    @Override
    public synchronized boolean addProduct(Product product) {
        if (isProductAvailable(availableProductTypes, product)) {
            return products.add(product);
        }
        throw new CustomException("This product of type is already on the shelf");
    }

    @Override
    public synchronized boolean addShelf(Shelf shelf) {
        return shelves.add(shelf);
    }

    public static List<Shelf> getShelves() {
        return List.copyOf(shelves);
    }

    public List<ProductType> getAvailableProductTypes() {
        return List.copyOf(availableProductTypes);
    }

    public List<Product> getProducts() {
        return List.copyOf(products);
    }

    public String getName() {
        return name;
    }


}
