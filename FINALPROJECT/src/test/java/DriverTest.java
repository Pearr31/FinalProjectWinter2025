import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.order.DeliveryOrder;
import org.example.foodsystem.user.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverTest {

    @Test
    public void testAddToAndDeliverPendingOrder() {
        Driver driver = new Driver("driver", "pass", "DRIVER01");
        driver.login("driver", "pass", "DRIVER01");

        DeliveryOrder order = new DeliveryOrder(List.of(new MenuItem("Sandwich", "Deli", 6.0)), driver, "789 Ave");
        driver.addToPendingOrders(order);
        driver.deliverNextOrder();
        Assertions.assertEquals("Delivered", order.getStatus());
    }

    @Test
    public void testDeliverPendingOrder() {
        Driver driver = new Driver("driver", "pass", "DRIVER01");
        driver.login("driver", "pass", "DRIVER01");

        DeliveryOrder order = new DeliveryOrder(List.of(new MenuItem("Sandwich", "Deli", 6.0)), driver, "789 Ave");
        driver.addToPendingOrders(order);

        Assertions.assertEquals("Pending", order.getStatus());
    }
}
