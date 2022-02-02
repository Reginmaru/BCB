public class Item {
    private String name;
    private Double price;

    public Item(String name){
        this.name = name;
        if (name.equals("Soup")){
            this.price = 0.65;
        }
        else if (name.equals("Bread")){
            this.price = 0.80;
        }
        else if (name.equals("Milk")){
            this.price = 1.30;
        }
        else if(name.equals("Apples")){
            this.price = 1.00;
        }else{ this.price = 0.00;}
        
    }

    public String getName(){
        return this.name;
    }
    public Double getPrice(){
        return this.price;
    }
    
}
