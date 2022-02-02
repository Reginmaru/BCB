import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemsTest {
    @Test
    public void ItemNameAndPrice(){
        Item apples = new Item("Apples");
        assertEquals(apples.getName(), "Apples");
        assertEquals(apples.getPrice(), 1.0);
    }
}
