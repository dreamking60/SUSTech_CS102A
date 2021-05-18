public class Food {
    private int id, size;
    private String name, type;
    private double price;

    public void showInformation(){
        System.out.printf("[id] %-2d [type] %-10s [name] %-10s [size] %2d (Inches) %.2f $\n", id, type, name, size, price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
