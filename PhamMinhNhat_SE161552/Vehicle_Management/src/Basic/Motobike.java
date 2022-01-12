package Basic;

/**
 *
 * @author nhattpam
 */
public class Motobike extends Vehicle{
    private int speed;
    private boolean license;

    public Motobike() {
    }

    public Motobike(String id, String name, String color, int price, String brand, int speed, boolean license) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.license = license;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + color + "," + price + "," + brand + "," + speed + "," + license;
    }
    
    
    @Override
    public void showInformation() { 
        System.out.printf("|%-10s|%-15s|%-10s|%10d|%10s|%10d|%15s|\n", id, name, color, price,brand, speed, license);
    }
    public void makeSound(){
        System.out.println("Tin tin tin");
    }
    
}
