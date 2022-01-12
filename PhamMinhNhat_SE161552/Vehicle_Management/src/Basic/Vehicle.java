package Basic;

/**
 *
 * @author nhattpam
 */
public abstract class Vehicle {
    protected String id;
    protected String name;
    protected String color;
    protected int price;
    protected String brand;
    //constructor mac dinh
    public Vehicle() {
    }
    //constructor day du
    public Vehicle(String id, String name, String color, int price, String brand) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    //getters, setter
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
    //In ra
    @Override      
    public String toString() {
        return "Vehicle{" + "id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", brand=" + brand + '}';
    }
    //ham hien thi Information
    abstract void showInformation();

}
