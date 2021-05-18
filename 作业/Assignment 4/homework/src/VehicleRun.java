import java.util.ArrayList;

public class VehicleRun {
    private String departureTime;
    private ArrayList<String> busLine;
    private boolean throughTicket;
    private float fee;
    private float income;
    private int[] pCntOn;
    private int[] pCntOff;

    public VehicleRun(String departureTime, ArrayList<String> busLine,
                      boolean throughTicket, float fee){
        this.departureTime = departureTime;
        this.fee = fee;
        this.throughTicket = throughTicket;
        this.busLine = busLine;
        pCntOff = new int[getBusLine().size()];
        pCntOn = new int[getBusLine().size()];
        income = 0;
    }

    public boolean updateCntOnStation(String xstation, int onNum, int offNum){
        int k = 0;
        for( int i = 0; i < getBusLine().size(); i++ ){
            if( xstation.equals(getBusLine().get(i))){
                pCntOn[i] = onNum;
                pCntOff[i] = offNum;
                k += 1;
            }
        }
        if( k == 0){
            return false;
        }else{
            return true;
        }
    }

    public boolean getFare( float fare){
        if( fare < 0){
            return false;
        }else{
            income += fare;
            return true;
        }
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public ArrayList<String> getBusLine() {
        return busLine;
    }

    public void setBusLine(ArrayList<String> busLine) {
        this.busLine = busLine;
    }

    public boolean isThroughTicket() {
        return throughTicket;
    }

    public void setThroughTicket(boolean throughTicket) {
        this.throughTicket = throughTicket;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public int[] getpCntOn() {
        return pCntOn;
    }

    public void setpCntOn(int[] pCntOn) {
        this.pCntOn = pCntOn;
    }

    public int[] getpCntOff() {
        return pCntOff;
    }

    public void setpCntOff(int[] pCntOff) {
        this.pCntOff = pCntOff;
    }
}
