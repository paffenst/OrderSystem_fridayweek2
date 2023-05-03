package service;
import model.Order;
import model.Product;
import repo.ProductRepo;
import repo.OrderRepo;

import java.util.*;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;
    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Product getProduct(int id) {
        return productRepo.getProduct(id);
    }

    public Order getOrder(int orderId) {
        return orderRepo.getOrder(orderId);
    }

    public void addOrder(int orderId, List<Integer> productIds) {
        List<Product> products = new ArrayList<>();
        for (int productId : productIds) {
            Product product = productRepo.getProduct(productId);
            products.add(product);
        }

        Order order = new Order(orderId, products);
        orderRepo.addOrder(order);
    }
    public List<Product> listProducts() {
        return productRepo.listProducts();
    }
    public List<Order> listOrders() {
        return orderRepo.listOrders();
    }

}
