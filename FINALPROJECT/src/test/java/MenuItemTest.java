import org.example.foodsystem.menu.MenuItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

    @Test
    public void testMenuItemProperties() {
        MenuItem item = new MenuItem("burger", "Fast Food", 5.99);

        String expectedName = "Burger";
        String expectedGenre = "Fast Food";
        double expectedPrice = 5.99;

        String result = item.getName();

        Assertions.assertEquals(expectedName, result);
    }
}
