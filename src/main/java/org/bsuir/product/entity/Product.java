package org.bsuir.product.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String name;
    private ProductType productType;
    private LocalDate expirationDate;

    public Product(Shelf shelf, String name, ProductType productType, LocalDate expirationDate) {
        this.name = name;
        this.productType = productType;
        this.expirationDate = expirationDate;
        shelf.addProduct(this);
    }

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;

        if (!Objects.equals(name, product.name)){
            return false;
        }
        if (productType != product.productType) {
            return false;
        }
        return Objects.equals(expirationDate, product.expirationDate);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 17 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        return result;
    }
}
