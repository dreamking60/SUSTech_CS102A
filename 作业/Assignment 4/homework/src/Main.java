import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int busNum = sc.nextInt();
        String list = sc.next();
        StringBuilder[] schedule = Schedule(list, busNum);
        if (schedule != null) {
            for (StringBuilder s : schedule)
                System.out.println(s.toString());
        }

    }

    public static StringBuilder[] Schedule(String timelist, int busNum) {
            String[] time = timelist.split("_");
            if (busNum <= 0) {
                StringBuilder[] schedule = new StringBuilder[1];
                schedule[0] = new StringBuilder();
                schedule[0].append("Bus Number is negative or zero, error!");
                return schedule;
            } else {
                for (int i = 0; i < time.length; i++) {
                    int n = 0;
                    for (int j = 0; j < time.length - i; j++) {
                        if (time[i].equals(time[i + j])) {
                            n = n + 1;
                        }
                    }
                    if (n > busNum) {
                        StringBuilder[] schedule = new StringBuilder[1];
                        schedule[0] = new StringBuilder();
                        schedule[0].append("Dispatching failed!");
                        return schedule;
                    }
                }
                int[] hour = new int[time.length];
                int[] minute = new int[time.length];
                for (int i = 0; i < time.length; i++) {
                    hour[i] = Integer.valueOf(time[i].substring(0, 2));
                    minute[i] = Integer.valueOf(time[i].substring(3));
                    if (hour[i] >= 25 || minute[i] >= 61) {
                        StringBuilder[] schedule = new StringBuilder[1];
                        schedule[0] = new StringBuilder();
                        schedule[0].append("Time Table error!");
                        return schedule;
                    }
                }
                for (int i = 0; i < time.length; i++) {
                    for (int j = 0; j < time.length - i; j++) {
                        if (hour[i] > hour[i + j]) {
                            StringBuilder[] schedule = new StringBuilder[1];
                            schedule[0].append("Time Table error!");
                            schedule[0] = new StringBuilder();
                            return schedule;
                        } else if (hour[i] == hour[i + j]) {
                            if (minute[i] > minute[i + j]) {
                                StringBuilder[] schedule = new StringBuilder[1];
                                schedule[0] = new StringBuilder();
                                schedule[0].append("Time Table error!");
                                return schedule;
                            }
                        }
                    }
                }
                StringBuilder[] schedule = new StringBuilder[busNum];
                for( int i = 0; i < busNum; i++){
                    schedule[i] = new StringBuilder();
                }
                for (int i = 0; i < time.length; i++) {
                    for (int j = 0; j < busNum; j++) {
                        if( i < busNum) {
                            if (i % busNum == j) schedule[j].append(time[i]);
                        }else{
                            if (i % busNum == j) schedule[j].append("_" + time[i]);
                        }
                    }
                }
                return schedule;
            }
        }
}

