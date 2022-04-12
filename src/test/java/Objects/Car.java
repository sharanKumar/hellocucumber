package Objects;

public class Car extends Person{



    public void getNameFromPerson(){
        String carName = name;
        String carHeight = height;
        System.out.println(getName());
        System.out.println("Static variable : " + Person.height);
        System.out.println("Static method : " + Person.exampleStaticMethod());
    }

}
