import org.example.MenuItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuItemtest {

    @Test
    public void testCompareTo() {
        MenuItem item1 = new MenuItem("Burger", 10.0,"Fast Food");
        MenuItem item2 = new MenuItem("Pizza", 30.5,"Italian");
        boolean expected = item2.getPrice()>item1.getPrice();
        MenuItem.PriceComparator result = new MenuItem.PriceComparator();
        Assertions.assertEquals(expected,result);
    }

}
