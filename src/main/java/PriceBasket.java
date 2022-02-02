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
            System.out.println("Apples 10% off: -" + 100*apple10 + "p\n");
        }
        if(breadHalf != 0 && apple10 == 0){
            System.out.println("Buy 2 soups get a bread half price: -" + 100*breadHalf +"p\n");
        }
        if(apple10 !=0 & breadHalf != 0){
            System.out.println("Buy 2 soups get a bread half price: -" + 100*breadHalf +"p");
            System.out.println("Apples 10% off: -" + 100*apple10 + "p\n");
        }
        if(apple10 == 0 & breadHalf == 0){
            System.out.println("(no offers available)\n");
        }
    }
    public Double getTotal(){
        return this.total;
    }
    public void printReceiptSubTotal(){
        if (r.getSubTotal() >= 1.00){
            System.out.println("Subtotal: "+ "£" + df.format(r.getSubTotal()) +"\n");
        }else{
            System.out.println("Subtotal: " + dfp.format(100*r.getSubTotal()) + "p\n");
        }
    }
    public void printReceiptTotal(){
        if (total >= 1.00){
            System.out.println("Total: "+ "£" + df.format(total) + "\n");
        }else{
            System.out.println("Total: " + dfp.format(100*total) + "p\n");
        }
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
