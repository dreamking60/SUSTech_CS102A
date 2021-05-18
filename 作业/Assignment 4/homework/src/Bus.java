import java.util.ArrayList;

public class Bus {
    private String licensePlate;
    private int seats;
    private ArrayList<VehicleRun> vrs;
    private int currentVrIndex = 0;

    public Bus(String licensePlate, int seats){
        this.licensePlate = licensePlate;
        this.seats = seats;
        vrs = null;
        currentVrIndex = 0;
    }

    public Bus( String licensePlate, int seats, ArrayList<VehicleRun> vrs){
        this.licensePlate = licensePlate;
        this.seats = seats;
        this.vrs = vrs;
    }

    public boolean arriveStation(int currentVrIndex, String xstation
    , ArrayList<Passenger> passengersGetOn, ArrayList<Passenger> passengersGetOff) {
        int numberIn = 0, numberOut = 0, people = 0, k = 0;
        for(int i = 0; i < vrs.get(currentVrIndex).getBusLine().size(); i++){
            if( xstation.equals(vrs.get(currentVrIndex).getBusLine().get(i))){
                k = i;
            }
        }
        for(int i = 0; i < k; i++) {
            people += vrs.get(currentVrIndex).getpCntOn()[i] - vrs.get(currentVrIndex).getpCntOff()[i];
        }
        if (xstation.equals(vrs.get(currentVrIndex).getBusLine().get(vrs.get(currentVrIndex).getBusLine().size()-1))) {
            if (people != passengersGetOff.size()) {
                return false;
            } else {
                if (passengersGetOn.size() > 0) {
                    return false;
                } else {
                    if (passengersGetOff.size() > people) {
                        return false;
                    } else {
                        for (int i = 0; i < passengersGetOff.size(); i++) {
                            if (passengersGetOff.get(i).getOff(vrs.get(currentVrIndex), xstation) == true) {
                                numberOut += 1;
                            }
                        }
                        vrs.get(currentVrIndex).updateCntOnStation(xstation, numberIn, numberOut);
                        return true;
                    }
                }
            }
        } else if (xstation.equals(vrs.get(currentVrIndex).getBusLine().get(0))) {
                if (passengersGetOff.size() > 0) {
                    return false;
                } else {
                    for (int i = 0; i < passengersGetOn.size(); i++) {
                        if (passengersGetOn.get(i).getOn(vrs.get(currentVrIndex), xstation) == true) {
                            numberIn += 1;
                        }
                    }
                    vrs.get(currentVrIndex).updateCntOnStation(xstation, numberIn, numberOut);
                    return true;
                }
            } else {
            if (passengersGetOff.size() > people) {
                return false;
            } else {
                for (int i = 0; i < passengersGetOn.size(); i++) {
                    if (passengersGetOn.get(i).getOn(vrs.get(currentVrIndex), xstation) == true) {
                        numberIn += 1;
                    }
                }
                for (int i = 0; i < passengersGetOff.size(); i++) {
                    if (passengersGetOff.get(i).getOff(vrs.get(currentVrIndex), xstation) == true) {
                        numberOut += 1;
                    }
                }
                vrs.get(currentVrIndex).updateCntOnStation(xstation, numberIn, numberOut);
                return true;
            }
        }
    }

    public void endCurrentOperation(){
        if( currentVrIndex < vrs.size()){
            currentVrIndex += 1;
        }else{
            System.out.println("WellDone,all the operations of Today has been finished, have a rest!!");
        }
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public ArrayList<VehicleRun> getVrs() {
        return vrs;
    }

    public void setVrs(ArrayList<VehicleRun> vrs) {
        this.vrs = vrs;
    }

    public int getCurrentVrIndex() {
        return currentVrIndex;
    }

    public void setCurrentVrIndex(int currentVrIndex) {
        this.currentVrIndex = currentVrIndex;
    }

}
