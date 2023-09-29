package ToyShop;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(10, 60);
        try {
            Ball.setQuantityInStock(20);
            TeddyBear.setQuantityInStock(10);
            Car.setQuantityInStock(150);
        }  catch (ToyOutOfStockException e) {
            System.out.println("number of toys in stock can't be negative");
        }
        Ball.setQuantityGiven(0);
        TeddyBear.setQuantityGiven(0);
        Car.setQuantityGiven(0);
        shop.lottery();
        shop.lottery();
        shop.lottery();
        shop.lottery();
        shop.giveToyToWinner("John Adams");
        shop.giveToyToWinner("Paul Black");
        shop.giveToyToWinner("Chris White");
        shop.giveToyToWinner("Mary Brown");
        shop.setTeddyBearPercentage(10);
        shop.lottery();
        shop.giveToyToWinner("Mark Smith");
    }
}
