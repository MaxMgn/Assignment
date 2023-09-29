package ToyShop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Shop {
    LinkedList<Toy> queueOfToys;
    int ballPercentage;
    private int teddyBearPercentage;
    private int carPercentage;

    public Shop(  int ballPercentage, int teddyBearPercentage) {
        this.queueOfToys = new LinkedList<>();
        setBallPercentage(ballPercentage);
        setTeddyBearPercentage(teddyBearPercentage);
        try {
            setCarPercentage();
        } catch (PercentageOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    public  void lottery() {
        Random rnd = new Random();
        int rndNumber = rnd.nextInt(100);
        if (rndNumber < ballPercentage){
            try {
                Ball.setQuantityInStock(Ball.getQuantityInStock()-1);
                queueOfToys.add(new Ball(Ball.getQuantityGiven() +1, "Ball"+ (Ball.getQuantityGiven()+1)));
                Ball.setQuantityGiven(Ball.getQuantityGiven()+1);
            } catch (ToyOutOfStockException e) {
                System.out.println("Balls " + e.getMessage());
            }
        }
        else if (rndNumber < ballPercentage + teddyBearPercentage){
            try {
                TeddyBear.setQuantityInStock(TeddyBear.getQuantityInStock()-1);
                queueOfToys.add(new TeddyBear(TeddyBear.getQuantityGiven() +1, "TeddyBear"+ (TeddyBear.getQuantityGiven() +1)));
                TeddyBear.setQuantityGiven(TeddyBear.getQuantityGiven()+1);
            } catch (ToyOutOfStockException e) {
                System.out.println("TeddyBears " + e.getMessage());
            }
        }
        else {
            try {
                Car.setQuantityInStock(Car.getQuantityInStock()-1);
                queueOfToys.add(new Car(Car.getQuantityGiven() +1, "Car"+ (Car.getQuantityGiven() +1)));
                Car.setQuantityGiven(Car.getQuantityGiven()+1);
            } catch (ToyOutOfStockException e) {
                System.out.println("Cars " + e.getMessage());
            }
        }
    }
    public void giveToyToWinner (String name){
        Toy toy =  queueOfToys.pollFirst();
        try
        {
            FileWriter writer = new FileWriter("notes.txt", true);
            writer.write(toy.toString() + " is given to " +  name);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println("check correctness of path to file");
        }
        catch (NullPointerException exc){
            System.out.println("No toy to be given: organize a lottery");
        }

    }


    public int getBallPercentage() {
        return ballPercentage;
    }

    public int getTeddyBearPercentage() {
        return teddyBearPercentage;
    }

    public int getCarPercentage() {
        return carPercentage;
    }

    public void setBallPercentage(int percentage) {
        if (percentage < 0 || percentage > 100){
            try {
                throw new PercentageOutOfBoundsException();
            } catch (PercentageOutOfBoundsException e) {
                System.out.println("Ball " + e.getMessage());
            }
        }
        else {
            this.ballPercentage  = percentage;;
            try {
                setCarPercentage();
            } catch (PercentageOutOfBoundsException e) {
                System.out.println("Wrong TeddyBear percentage is input: it cause car" + e.getMessage());
                this.ballPercentage = 100 - (getTeddyBearPercentage() + getCarPercentage());
            }
        }
    }

    public void setTeddyBearPercentage(int percentage) {
        if (percentage < 0 || percentage > 100){
            try {
                throw new PercentageOutOfBoundsException();
            } catch (PercentageOutOfBoundsException e) {
                System.out.println("TeddyBear " + e.getMessage());
            }
        }
        else {
            this.teddyBearPercentage  = percentage;
            try {
                setCarPercentage();
            } catch (PercentageOutOfBoundsException e) {
                System.out.println("Wrong TeddyBear percentage is input: it causes car" + e.getMessage());
                this.teddyBearPercentage =  100 - (getCarPercentage() + getBallPercentage());
            }
        }
    }

    public void setCarPercentage() throws PercentageOutOfBoundsException {
        if (getBallPercentage() + getTeddyBearPercentage()  > 100){
            throw new PercentageOutOfBoundsException();
        }
        else {
            this.carPercentage = 100 - (getBallPercentage() + getTeddyBearPercentage());
        }
    }
}
