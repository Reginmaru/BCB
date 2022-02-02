import java.text.DecimalFormat;
import java.time.LocalDate;

public class PriceBasket {
    private Double total;
    private Receipt r;
    
    public PriceBasket(String... s){
        r = new Receipt(s);
    }
    public Receipt getReceipt(){
        return r;
    }
    public String convert(double amount){
        String s= "";
        if (amount >= 1.00){
            s += "£" + df.format(amount);
        }else{
            s += dfp.format(100*amount) + "p";
        }
        return s;
    }
    public void calculateTotal(){
        this.total = r.getSubTotal();
        double apple10 = 0;
        for (Item apples: r.getArrayList()){
            if(apples.getName().equals("Apples") && LocalDate.now().compareTo(LocalDate.parse("2022-02-07")) < 0){ 
                apple10 += 0.1;
                this.total -= apple10;
            }
        }
        int soupCount = 0;
        for (Item soups: r.getArrayList()){
            if(soups.getName().equals("Soup")){
                soupCount++;
            } 
        }
        double breadDiscountPrice = 0;
        int breadCount = 0;
        for (Item bread: r.getArrayList()){
            if(bread.getName().equals("Bread")){
                breadCount ++;
                if(soupCount%(breadCount*2) ==0 | soupCount%(breadCount*2) ==1){
                    breadDiscountPrice = 0.4*breadCount;
                }
            }
        }
        this.total -= breadDiscountPrice;
        if(apple10 != 0 && breadDiscountPrice == 0){
            System.out.println("Apples 10% off: -" + convert(apple10) +"\n");
        }
        if(breadDiscountPrice != 0 && apple10 == 0){
            System.out.println("Buy 2 soups get a bread half price: -" + convert(breadDiscountPrice) +"\n");
        }
        if(apple10 !=0 & breadDiscountPrice != 0){
            System.out.println("Apples 10% off: -" + convert(apple10));
            System.out.println("Buy 2 soups get a bread half price: -" + convert(breadDiscountPrice) +"\n");
        }
        if(apple10 == 0 & breadDiscountPrice == 0){
            System.out.println("(no offers available)\n");
        }
    }
    public Double getTotal(){
        return this.total;
    }
    public void printReceiptSubTotal(){
        System.out.println("SubTotal: " + convert(r.getSubTotal())+"\n");
    }
    public void printReceiptTotal(){
        System.out.println("Total: " + convert(total));
    } 
    
    public static void main(String[] args){
        PriceBasket pb = new PriceBasket(args);
        pb.r.setSubTotal();
        pb.printReceiptSubTotal();
        pb.calculateTotal();
        pb.printReceiptTotal();
    }
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final DecimalFormat dfp = new DecimalFormat("0");
}
