package hellocucumber;

import Objects.Person;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepDefinitions {

    int a = 0 ;
    int b = 1 ;
    int i = 5 ;

    @Given("I add two numbers")
    public void i_add_two_numbers() {
        // Write code here that turns the phrase above into concrete actions
        int c = a + b;
        i = 9 ;
        int i = 2 ;
        System.out.println("Variable Output 1 :" + i );
    }

    @When("I find the result")
    public void i_find_the_result() {
        // Write code here that turns the phrase above into concrete actions
       i = 3 ;
       System.out.println("Variable Output 2 :" + i );
    }

    @Given("I create an Object in Person class")
    public void i_createAnObject() {
        // Write code here that turns the phrase above into concrete actions
        Person person = new Person();
        String stepName = person.name;

        System.out.println(person.getName());
    }

}
