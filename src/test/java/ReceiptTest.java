import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {
    @Test
    public void ContainsItems(){
        Receipt receipt = new Receipt("Apples");
        receipt.setSubTotal();
        assertEquals(receipt.getSubTotal(),1.0);
    }
    @Test
    public void ContainsMultipleItems(){
        Receipt receipt = new Receipt("Apples","Soup","Milk","Bread");
        receipt.setSubTotal();
        assertEquals(receipt.getSubTotal(),3.75);
    }
}