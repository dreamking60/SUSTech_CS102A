public class Passenger {
    private static int cnt = 0;
    private int id = 0;
    private float balance = 0;
    private String boardingStation = null;

    public Passenger(){
        boardingStation = null;
        balance = (float) 0.0;
        cnt += 1;
        id = cnt;
    }

    public Passenger( float money ){
        balance = money;
        boardingStation = null;
        cnt += 1;
        id = cnt;
    }

    public boolean getOn( VehicleRun vr, String station){
        int k = 0;
        for( int i = 0; i < vr.getBusLine().size(); i++ ){
            if( station.equals(vr.getBusLine().get(i)) ){
                k += 1;
            }
        }
        if( k == 0 ){
            return false;
        }else {
            if (boardingStation == null) {
                if( balance > 0 ) {
                    if (vr.isThroughTicket() == true) {
                        if (vr.getFee() <= balance) {
                            balance -= vr.getFee();
                            vr.getFare(vr.getFee());
                            boardingStation = station;
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        boardingStation = station;
                        return true;
                    }
                }else{
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public boolean getOff(VehicleRun vr, String station){
        int k = 0, t = 0, a = 0, b = 0;
        float fare = 0;
        for( int i = 0; i < vr.getBusLine().size(); i++ ){
            if( station.equals(vr.getBusLine().get(i)) ){
                k += 1;
                a = i;
            }
            if( boardingStation != null) {
                if (boardingStation.equals(vr.getBusLine().get(i))) {
                    t += 1;
                    b = i;
                }
            }
        }
        if( boardingStation == null ){
            return false;
        }else {
            if (k == 0) {
                return false;
            } else {
                if (t == 0) {
                    return false;
                } else {
                    if (a < b) {
                        return false;
                    } else {
                        if (vr.isThroughTicket() == true) {
                            boardingStation = null;
                            return true;
                        } else {
                            fare = vr.getFee() * (a - b);
                            balance -= fare;
                            vr.getFare(fare);
                            boardingStation = null;
                            return true;
                        }
                    }
                }
            }
        }
    }

    public boolean refill(float money){
        if( money > 0 ){
            balance += money;
            return true;
        }else{
            return false;
        }
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Passenger.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getBoardingStation() {
        return boardingStation;
    }

    public void setBoardingStation(String boardingStation) {
        this.boardingStation = boardingStation;
    }


}
