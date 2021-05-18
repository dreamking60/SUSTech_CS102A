public abstract class Movie {
    //Must declare first six fields
    private int id = 1;
    private String name;
    private Time startTime;
    private int runtime;
    private double price;
    protected int ticketsLeft;

    public Movie(String name, Time startTime, int runtime, double price, int tickets){
        this.name = name;
        this.startTime = startTime;
        this.runtime = runtime;
        this.price = price;
        ticketsLeft = tickets;
        id += 1;
    }

    public Movie() {

    }
    //You can add other fields that you think are necessary.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double purchase(int arg);

    @Override
    public String toString() {
        return
                "id=" + id + ", name='" + name +
                        "', startTime:" + startTime +
                        ", runtime=" + runtime +
                        ", price=" + price +
                        ", ticketsLeft=" + ticketsLeft;
    }
}
