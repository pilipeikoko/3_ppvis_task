package org.bsuir.product.validator;

import org.bsuir.product.entity.Product;
import org.bsuir.product.entity.ProductType;

import java.util.List;

public class ShelfValidator {
    private ShelfValidator() {

    }

    public static boolean isProductAvailable(List<ProductType> productTypes, Product product) {
        for (ProductType productType : productTypes) {
            if (productType.equals(product.getProductType())) {
                return false;
            }
        }
        return true;
    }
}
