
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Receipt {

    private static ArrayList<Item> itemList = new ArrayList<Item>();
    private static double subtotal;

    public double getSubtotal(){
         return subtotal;
    }
    
    public static void main(String[]args){
        for(int i = 0; i < args.length; i++){
            itemList.add(new Item(args[i]));
        }
        if (subtotal >= 1.00){
            System.out.println("subtotal: "+ "£" + df.format(subtotal));
        }else{
            System.out.println("subotal: " + dfp.format(100*subtotal) + "p");
        }
    }
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final DecimalFormat dfp = new DecimalFormat("0");
}
