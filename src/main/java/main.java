import model.Order;
import model.Product;
import repo.OrderRepo;
import repo.ProductRepo;
import service.ShopService;

import java.util.List;

public class main {
    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Product product = shopService.getProduct(4);
        System.out.println("Product 4: " + product);
        System.out.println(product);

        System.out.println("List of all products:\n");
        List<Product> products = shopService.listProducts();
        System.out.println(products);

        shopService.addOrder(2, List.of(1,2));
        shopService.addOrder(3, List.of(2,4));

        System.out.println("First Order :\n");
        Order order1 = shopService.getOrder(2);
        System.out.println(order1);

        System.out.println("Second Order :\n");
        Order order2 = shopService.getOrder(3);
        System.out.println(order2);

        System.out.println("All orders:\n");
        List<Order> orders = shopService.listOrders();
        System.out.println(orders);

    }
}
