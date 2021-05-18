import java.util.ArrayList;
public class FoodTest {
    public static void main(String[] args) {
        System.out.println("-------------------welcome,this is Start of the Menu-------------------");
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
        for( int i = 0; i < 4; i++ ){
            FoodList.get(i).showInformation();
        }
        System.out.println("-------------------welcome,this is  End  of the Menu-------------------");
    }
}
