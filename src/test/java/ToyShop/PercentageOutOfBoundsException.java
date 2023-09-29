package ToyShop;

public class PercentageOutOfBoundsException extends Exception{
    @Override
    public String getMessage() {
        return "percentage is out of bounds";
    }
}
