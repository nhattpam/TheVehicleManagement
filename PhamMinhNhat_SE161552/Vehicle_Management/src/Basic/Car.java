package Basic;

/**
 *
 * @author nhattpam
 */
public class Car extends Vehicle{
    private String type;
    private int date;
    //construct mac dinh
    public Car() {
    }
    //constructor day du
    public Car(String id, String name, String color, int price, String brand, String type, int date) {
        super(id, name, color, price, brand);
        this.type = type;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    
    //in ra
    @Override
    public String toString() {
        return id + "," + name + "," + color + "," + price + "," + brand + "," + type + "," + date;
    }
    //in ra INfor
    @Override
    void showInformation() {
        System.out.printf("|%-10s|%-15s|%-10s|%10d|%10s|%10s|%15d|\n", id, name, color, price,brand, type, date);
    }
}
