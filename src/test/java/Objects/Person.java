package Objects;

public class Person {

    public String name = "Sharan";
    public static String height = "2Inch";

    public String getName(){
        return name;
    }

    public static String exampleStaticMethod(){
        System.out.println("Static method");
        return "static";
    }

}
