import java.util.ArrayList;
import java.util.Scanner;
public class softOpen {
    public static ArrayList<Food> generateMenu(){
        Food food1 = new Food();
        Food food2 = new Food();
        Food food3 = new Food();
        Food food4 = new Food();
        food1.setId(1);
        food1.setName("pizza");
        food1.setType("Seafood");
        food1.setSize(11);
        food1.setPrice(12);
        food2.setId(2);
        food2.setName("Pizza");
        food2.setType("Beef");
        food2.setSize(9);
        food2.setPrice(10);
        food3.setId(3);
        food3.setName("fried rice");
        food3.setType("Seafood");
        food3.setSize(5);
        food3.setPrice(12);
        food4.setId(4);
        food4.setName("noodles");
        food4.setType("Beef");
        food4.setSize(6);
        food4.setPrice(14);
        ArrayList<Food> FoodList =  new ArrayList<Food>();
        FoodList.add(food1);
        FoodList.add(food2);
        FoodList.add(food3);
        FoodList.add(food4);
        return FoodList;
    }
    public static void getMenu(ArrayList<Food> FoodList){
        System.out.println("-------------------welcome,this is Start of the Menu-------------------");
        for( int i = 0; i < 4; i++ ){
            FoodList.get(i).showInformation();
        }
        System.out.println("-------------------welcome,this is  End  of the Menu-------------------");
    }
    public static User generateUser(Scanner in){
        System.out.print("Generate a user, please input name:");
        User user = new User();
        String name = in.next();
        user.setUser(name);
        System.out.print("balance($):");
        double money = in.nextDouble();
        user.setMoney(money);
        user.setPassword("123456");
        return user;
    }
    public static void UserConsume(ArrayList<Food> FoodList, User user, Scanner in){
        getMenu(FoodList);
        int id = 0;
        double price = 0;
        System.out.println("please input the foodID and number you want, to exit input 0 as foodID");
        do{
            System.out.print("food id(input 0 to end elect):");
            id = in.nextInt();
            if( id != 0) {
                System.out.print("number of this food:");
                int number = in.nextInt();
                price += number * FoodList.get(id - 1).getPrice();
            }
        }while( id != 0);
        System.out.println("select end");
        user.expense(price,in);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Food> foodList = generateMenu(); //generate a Menu
        User user = generateUser(in); //generate a user
        user.introduce(); //show the account of the user
        UserConsume(foodList,user,in); //user consume
        user.introduce(); //show the account of the user
        in.close();
    }
}
