package org.bsuir.product.entity;

public interface Buyer {
    Product findProductByTypeOnShelf(Shelf shelf,ProductType productType);
    boolean moveProductToOwnShelf(Product product);
}
