
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.DecimalFormat;

public class PriceBasketTest {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @Test
    public void DiscountAppliedApples(){
        PriceBasket pb = new PriceBasket("Apples");
        pb.getReceipt().setSubTotal();
        pb.calculateTotal();
        assertEquals(pb.getTotal(), 0.90);
    }
    @Test
    public void DiscountAppliedSoups(){
        PriceBasket pb = new PriceBasket("Soup","Soup","Bread");
        pb.getReceipt().setSubTotal();
        pb.calculateTotal();   
        assertEquals(df.format(pb.getTotal()), df.format(1.70));
    }
    @Test
    public void DiscountsApplied(){
        PriceBasket pb = new PriceBasket("Soup","Soup","Bread","Apples");
        pb.getReceipt().setSubTotal();
        pb.calculateTotal();   
        assertEquals(df.format(pb.getTotal()), df.format(2.60));
    }
    @Test
    public void addingNothing(){
        PriceBasket pb = new PriceBasket();
        pb.getReceipt().setSubTotal();
        pb.calculateTotal();   
        assertEquals(df.format(pb.getTotal()), df.format(0));
    }
    @Test
    public void addingWrongItem(){
        PriceBasket pb = new PriceBasket("Shark");
        pb.getReceipt().setSubTotal();
        pb.calculateTotal();   
        assertEquals(df.format(pb.getTotal()), df.format(0));
    }
}
