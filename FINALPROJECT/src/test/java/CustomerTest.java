import org.example.foodsystem.DiscountManager.DiscountManager;
import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.user.Customer;
import org.example.foodsystem.user.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {


    @Test
    public void testPlaceTakeoutOrder() {
        Customer customer = new Customer("cust", "pass", "123 St");
        List<MenuItem> items = List.of(new MenuItem("Pizza", "Fast Food", 12.0));
        Order order = customer.placeOrder("Takeout", items, null, "");
        Assertions.assertEquals("Takeout", order.getOrderType());
        Assertions.assertEquals(12.0, order.getTotalPrice());
    }

    @Test
    public void testPlaceDeliveryOrderWithDiscount() {
        Customer customer = new Customer("cust", "pass", "456 St");
        Driver driver = new Driver("driver", "pass", "DRIVER01");
        DiscountManager.addCode("DISC15");
        List<MenuItem> items = List.of(new MenuItem("Burger", "Fast Food", 10.0));
        Order order = customer.placeOrder("Delivery", items, driver, "DISC15");
        Assertions.assertEquals("Delivery", order.getOrderType());
        Assertions.assertEquals(13.175, order.getTotalPrice());


    }
}
