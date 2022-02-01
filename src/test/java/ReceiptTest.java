
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {
    Receipt receipt;
    
    @Test
    // Before adding discounts, just checking if I can add items to my receipt
    public void testContainsItems(){
        receipt = new Receipt();
        assertEquals(receipt.addItem("apple"), "subtotal: £1.00")
    }
}