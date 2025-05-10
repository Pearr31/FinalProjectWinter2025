import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.order.TakeoutOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TakeoutOrderTest {


    @Test
    public void testTakeoutOrderTotal() {
        TakeoutOrder order = new TakeoutOrder(List.of(new MenuItem("Tea", "Drink", 2.0), new MenuItem("Cookie", "Dessert", 3.0)));
        Assertions.assertEquals(5.0, order.getTotalPrice());
    }
}
