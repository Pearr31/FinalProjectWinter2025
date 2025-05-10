import org.example.foodsystem.menu.MenuItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

    @Test
    public void testMenuItemProperties() {
        MenuItem item = new MenuItem("Burger", "Fast Food", 5.99);

        String expectedName = "Burger";
        String expectedGenre = "Fast Food";
        double expectedPrice = 5.99;

        Assertions.assertEquals(expectedName, item.getName());
        Assertions.assertEquals(expectedGenre, item.getGenre());
        Assertions.assertEquals(expectedPrice, item.getPrice());
    }
}
