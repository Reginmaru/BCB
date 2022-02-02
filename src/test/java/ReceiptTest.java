

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {
    Receipt receipt;

    @Test
    // Before adding discounts, just checking if I can add items to my receipt
    public void testContainsItems(){
        receipt = new Receipt();
        

        assertEquals(receipt.getSubtotal(),1.0);
    }
}