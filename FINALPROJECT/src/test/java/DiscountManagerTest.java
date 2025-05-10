import org.example.foodsystem.DiscountManager.DiscountManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountManagerTest {
    @Test
    public void testAddAndValidateCode() {
        DiscountManager.addCode("MONKEY");
        Assertions.assertTrue(DiscountManager.isValidCode("MONKEY"));
        Assertions.assertFalse(DiscountManager.isValidCode("INVALID"));
    }

}
