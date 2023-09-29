package ToyShop;

public class Car extends Toy{
    private static int quantityInStock;

    private static int quantityGiven;

    public Car(int id, String name) {
        super(id, name);
    }
    public static int getQuantityInStock() {
        System.out.println(quantityInStock);
        return quantityInStock;
    }

    public static void setQuantityInStock(int quantity) throws ToyOutOfStockException{
        if (quantity < 0){
            throw new ToyOutOfStockException ();
        }
        else{
            quantityInStock = quantity;
            //System.out.println(Toy.quantityInStock);
        }

    }
    public static int getQuantityGiven() {
        return quantityGiven;
    }

    public static void setQuantityGiven(int quantity) {
        quantityGiven = quantity;
    }

}
