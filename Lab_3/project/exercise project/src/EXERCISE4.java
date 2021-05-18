public class EXERCISE4 {
    public static void main(String[] args) {
        if (args.length != 4){
            System.out.println("Usage: java EXERCISE4 name(string) age(integer) weight(float) grade(A'\'B'\'C'\'D)");
            System.exit(1);
        }
        String name = args[0];
        int age = Integer.parseInt(args[1]);
        float weight = Float.parseFloat(args[2]);
        char grade = args[3].charAt(0);
        System.out.printf("Your name is %s.\n You are %d years old.\n", name, age);
        System.out.printf("You weigh %.1f KG.\nThe highest grade you got in last semester is %c", weight,grade);
    }
}
