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
        int twoSoups = 0;
        for (Item soups: r.getArrayList()){
            if(soups.getName().equals("Soup")){
                twoSoups++;
            } 
        }
        double breadHalf = 0;
        for (Item bread: r.getArrayList()){
            if(bread.getName().equals("Bread")){
                breadHalf += 0.4*(twoSoups/2);
                this.total -= breadHalf;
            }
        }
        if(apple10 != 0 && breadHalf == 0){
            System.out.println("Apples 10% off: -" + convert(apple10) +"\n");
        }
        if(breadHalf != 0 && apple10 == 0){
            System.out.println("Buy 2 soups get a bread half price: -" + convert(breadHalf) +"\n");
        }
        if(apple10 !=0 & breadHalf != 0){
            System.out.println("Apples 10% off: -" + convert(apple10));
            System.out.println("Buy 2 soups get a bread half price: -" + convert(breadHalf) +"\n");
        }
        if(apple10 == 0 & breadHalf == 0){
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
