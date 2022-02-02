
import java.util.ArrayList;

public class Receipt {
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private double subtotal;

    public ArrayList<Item> getArrayList(){
        return itemList;
    }
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
    public static void main(String[]args){
        Receipt r = new Receipt();
        for(int i = 0; i < args.length; i++){
            r.itemList.add(new Item(args[i]));
        }
        r.setSubTotal();    
    }
}
