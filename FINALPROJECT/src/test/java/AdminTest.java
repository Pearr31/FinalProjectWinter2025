import org.example.foodsystem.user.Admin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminTest {


    @Test
    public void testLogin_NormalInputs() {
        Admin admin = new Admin("admin1", "adminpass", "adminCode");
        boolean expected = true;
        boolean result = admin.login("admin1", "adminpass", "adminCode");

        Assertions.assertEquals(expected, result);
    }

}
