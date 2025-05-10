import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.order.DeliveryOrder;
import org.example.foodsystem.user.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryOrderTest {
    @Test
    public void testDeliveryOrderTotal() {
        Driver driver = new Driver("d", "p", "DRIVER01");
        DeliveryOrder order = new DeliveryOrder(List.of(new MenuItem("Salad", "Healthy", 7.0)), driver, "321 Lane");
        Assertions.assertEquals(12.5, order.getTotalPrice());
    }

}
