import org.junit.jupiter.api.Assertions;

import java.util.NoSuchElementException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Test {
    @org.junit.jupiter.api.Test
    void should_Get_The_exact_Product() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);
        //when
        Product actual = shopService.getProduct(2);
        //then
        assertThat(actual).isEqualTo(new Product(2, "cookies"));
    }

    @org.junit.jupiter.api.Test
    void service_adding_New_Products_And_Show_Orders() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);
        //when
        shopService.addOrder(1000, List.of(4, 3, 2, 1));
        List<Order> actual = shopService.listOrders();
        //then
        List<Order> expected = List.of(new Order(1000, List.of(new Product(4, "croissant"), new Product(3, "coffee"), new Product(2, "cookies"), new Product(1, "espresso"))));
        assertThat(actual).hasSameElementsAs(expected).hasSize(expected.size());
    }

    @org.junit.jupiter.api.Test
    void should_Print_The_List_Of_Products() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);
        //when
        List<Product> actual = shopService.listProducts();
        //then
        List<Product> expected = List.of(new Product(1, "espresso"), new Product(2, "cookies"), new Product(3, "coffee"), new Product(4, "croissant"));
        assertThat(actual).hasSameElementsAs(expected).hasSize(expected.size());
    }

    @org.junit.jupiter.api.Test
    void expectExceptionWhenNoneExistingProductCome() {
        //given
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);
        //when
        try {
            shopService.addOrder(12, List.of(12));
            Assertions.fail("is released");
        } catch (NoSuchElementException e) {
            System.out.println("That Good - erwartet Expception auf nicht vorhandenes Produkt");
        }
    }

}