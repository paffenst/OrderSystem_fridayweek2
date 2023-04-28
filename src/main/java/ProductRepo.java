import java.util.*;

public class ProductRepo {
    public Map<Integer, Product> products = Map.of(
            1, new Product(1, "espresso"),
            2, new Product(2, "cookies"),
            3, new Product(3, "coffee"),
            4, new Product(4, "croissant"));
    public Product getProduct(int id) {
        Product product = products.get(id);
        if (product == null) {
            throw new NoSuchElementException("Product with id " + id + " didn't found in this product list.");
        }
        return product;
    }

    public List<Product> listProducts() {
        return new ArrayList<>(products.values());
    }
}