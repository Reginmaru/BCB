

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {
    @Test
    // Before adding discounts, just checking if I can add items to my receipt
    public void testContainsItems(){
        Receipt receipt = new Receipt("Apples");
        receipt.setSubTotal();
        assertEquals(receipt.getSubTotal(),1.0);
    }
    @Test
    public void testContainsMultipleItems(){
        Receipt receipt2 = new Receipt("Apples","Soup","Milk","Bread");
        receipt2.setSubTotal();
        assertEquals(receipt2.getSubTotal(),3.75);
    }

}