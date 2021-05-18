public class ThreeDMovie extends Movie{
    private final int GLASS_PRICE = 20;

    public ThreeDMovie(String name, Time startTime, int runtime, double price, int tickets){
        super(name, startTime, runtime, price, tickets);
    }
    @Override
    public String toString() {
        return super.toString() + " ThreeDMovie";
    }

    @Override
    public double purchase(int arg) {
        if( ticketsLeft > 0) {
            ticketsLeft -= 1;
            return arg * GLASS_PRICE + super.getPrice();
        }else{
            return 0;
        }
    }
}
