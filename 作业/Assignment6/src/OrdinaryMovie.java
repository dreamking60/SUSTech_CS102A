public class OrdinaryMovie extends Movie{
    public OrdinaryMovie(String name, Time startTime, int runtime, double price, int tickets){
        super(name, startTime, runtime, price, tickets);
    }
    @Override
    public String toString() {
        return super.toString()+" OrdinaryMovie";
    }

    @Override
    public double purchase(int arg) {
        if( arg < super.ticketsLeft ){
            ticketsLeft -= arg;
            return arg * getPrice();
        }else{
            ticketsLeft -= ticketsLeft;
            return super.ticketsLeft * getPrice();
        }
    }
}
