public class Item {
    private String name;
    private Double price;

    public Item(String name){
        this.name = name;
        if (name == "Soup"){
            this.price = 0.65;
        }
        else if (name == "Bread"){
            this.price = 0.80;
        }
        else if (name == "Milk"){
            this.price = 1.30;
        }
        else if(name == "Apples"){
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
