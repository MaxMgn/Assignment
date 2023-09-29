package ToyShop;

public class ToyOutOfStockException extends Exception{
    @Override
    public String getMessage() {
        return "are out of stock";
    }
}
