import org.example.foodsystem.user.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private Customer customer;

    @Test
    public void testAddress_NormalInput() {
        Customer customer = new Customer("John", "pass", "Elmo Street");
        String expected = "123 Street";
        String result = customer.getAddress();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAddress_NullInputs() {
        Customer customer = new Customer("John", null, "Elmo Street");
        String expected = "123 Street";
        String result = customer.getAddress();
        Assertions.assertEquals(expected, result);
    }


}
