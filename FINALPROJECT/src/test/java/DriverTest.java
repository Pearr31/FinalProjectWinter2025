import org.example.foodsystem.user.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DriverTest {

    @Test
    public void testDriverLogin() {
        Driver driver = new Driver("driver1", "drivepass", "driveCode");
        boolean input = driver.login("driver1", "drivepass", "driveCode");
        boolean expected = true;
        boolean result = input;

        Assertions.assertEquals(expected, result);
    }
}
