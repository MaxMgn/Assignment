package ToyShop;

public abstract class Toy {

    private int id;
    private String name;


//    public static void setPercentage(int percentage) {
//
//    }
//
//    public static int getPercentage () {
//
//        return percentage;
//    }
    public Toy(int id, String name) {
        this.id = id;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
