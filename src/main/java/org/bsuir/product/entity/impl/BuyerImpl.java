package org.bsuir.product.entity.impl;

import org.bsuir.product.exception.CustomException;
import org.bsuir.product.entity.Buyer;
import org.bsuir.product.entity.Product;
import org.bsuir.product.entity.ProductType;
import org.bsuir.product.entity.Shelf;

import java.time.LocalDate;
import java.util.List;

public class BuyerImpl implements Buyer {
    private final Shelf ownShelf;

    {
        ownShelf = new ShelfImpl();
    }

    @Override
    public synchronized Product findProductByTypeOnShelf(Shelf shelf, ProductType productType) {
        List<Product> products = shelf.getProducts();

        for (Product product : products) {
            if (product.getProductType().equals(productType)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public synchronized boolean moveProductToOwnShelf(Product productToMove) {
        List<Shelf> shelves = ShelfImpl.getShelves();

        for (Shelf shelf : shelves) {
            List<Product> products = shelf.getProducts();
            for (Product product : products) {
                if (product.equals(productToMove) && LocalDate.now().compareTo(product.getExpirationDate()) > 0) {
                    products.remove(product);
                    ownShelf.addProduct(product);
                    return true;
                }
            }
        }
        throw new CustomException("Product not found");
    }
}
