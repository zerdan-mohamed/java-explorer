package org.codewithme.collections;

import lombok.Getter;
import org.codewithme.models.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShipmentList implements Iterable<Product> {
    // Interfaces define behavior. Implementations determine performance

    // ArrayList :
    //  - good general purpose implementation
    //  - use as a default
    //  - CPU cache sympathetic
    //  - performance complexity: get -> O(1), add -> O(1|N), contains -> O(N), remove -> O(1|N)

    // LinkedList :
    //  - worse performance in most cases
    //  - use when adding elements at start
    //  - use when adding/removing a lot
    //  - performance complexity : get -> O(N), add -> O(1|N), contains -> O(N), remove -> O(1|N)

    private static final int MISSING_PRODUCT = -1;
    private static final int CHEAP_MAX_PRICE = 200;

    private final List<Product> products = new ArrayList<>();

    @Getter
    private List<Product> cheapProducts;

    @Getter
    private List<Product> expensiveProducts;

    public void add(Product product) {
        products.add(product);
    }

    public boolean replace(Product oldProduct, Product newProduct) {
        int productIndex = products.indexOf(oldProduct);

        if (productIndex == MISSING_PRODUCT) {
            return false;
        } else {
            products.set(productIndex, newProduct);
        }

        return true;
    }

    public boolean replaceAll(Product oldProduct, Product newProduct) {
        boolean update = products.contains(oldProduct);
        if (update) {
            products.replaceAll(product -> product == oldProduct ? newProduct : product);
        }
        return true;
    }

    public void prepare() {
        products.sort(Product.BY_PRICE);
        int splintPoint = findSplitPoint();
        cheapProducts = products.subList(0, splintPoint);
        expensiveProducts = products.subList(splintPoint, products.size());
    }

    public boolean stripExpensiveProducts() {
        return products.removeIf(product -> product.price() > CHEAP_MAX_PRICE);
    }

    private int findSplitPoint() {
        int size = products.size();
        for (int i=0; i<size; i++) {
            var product = products.get(i);
            if (product.price() > CHEAP_MAX_PRICE) {
                return i;
            }
        }

        return products.size();
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
