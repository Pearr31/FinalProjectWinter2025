import org.example.foodsystem.DiscountManager.DiscountManager;
import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.order.TakeoutOrder;
import org.example.foodsystem.user.Admin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminTest {


    @Test
    public void testAddDiscountCode() {
        Admin admin = new Admin("admin", "pass", "ADMIN01");
        admin.login("admin", "pass", "ADMIN01");
        admin.addDiscountCode("SAVE");
        Assertions.assertTrue(DiscountManager.isValidCode("SAVE"));
    }

    @Test
    public void testUpdatePickupTime() {
        Admin admin = new Admin("admin", "pass", "ADMIN01");
        admin.login("admin", "pass", "ADMIN01");
        TakeoutOrder order = new TakeoutOrder(List.of(new MenuItem("Soup", "Hot", 4.0)));
        admin.updatePickupTime(order, 30);
        Assertions.assertEquals("Ready for Pickup", order.getStatus());
        Assertions.assertEquals("30 minutes from now", order.getPickupTime());
    }

}
