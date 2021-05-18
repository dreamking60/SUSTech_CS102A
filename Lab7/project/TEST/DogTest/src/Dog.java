public class Dog {
     private String name;
     private String breed;
     public Dog(String dogname, String dogbreed){
          name = dogname;
          breed = dogbreed;
     }
     public void selfinfo(){
          System.out.printf("My name is %s. I am a %s.\n", name, breed);
     }
}
