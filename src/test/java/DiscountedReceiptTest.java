
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.DecimalFormat;

public class DiscountedReceiptTest {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @Test
    public void DiscountAppliedApples(){
        PriceBasket pb = new PriceBasket("Apples");
        pb.getReceipt().setSubTotal();
        pb.calculateTotal();
        assertEquals(dr.getTotal(), 0.90);
    }
    @Test
    public void DiscountAppliedSoups(){
        PriceBasket pb = new PriceBasket("Soup","Soup","Bread");
        pb.getReceipt().setSubTotal();
        pb.calculateTotal();

        
        assertEquals(df.format(pb.getTotal()), 1.70); // Need to change the format to this passes, using command line it says 1.70000000002
    }
}
