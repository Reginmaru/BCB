
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Receipt {

    private ArrayList<Item> itemList = new ArrayList<Item>();
    private double subtotal;
    
    public Receipt(String... s){
        for(int i = 0; i < s.length; i++){
            itemList.add(new Item(s[i]));
        }
    }

    public void setSubTotal(){
         for(Item i:itemList){
             this.subtotal += i.getPrice();
         }
    }
    public Double getSubTotal(){
        return subtotal;
    }
   
    public void printReceipt(){
        if (subtotal >= 1.00){
            System.out.println("subtotal: "+ "£" + df.format(subtotal));
        }else{
            System.out.println("subotal: " + dfp.format(100*subtotal) + "p");
        }
    } 

    public static void main(String[]args){
        Receipt r = new Receipt();
        for(int i = 0; i < args.length; i++){
            r.itemList.add(new Item(args[i]));
        }
        r.setSubTotal();
        r.printReceipt();  
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final DecimalFormat dfp = new DecimalFormat("0");
}
