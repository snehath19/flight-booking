package stepDefenitions;

import Utilities.Helper;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks
{
    @Before(order=0)
    public void beforeScenarioStart(){
        System.out.println("-----------------Start of Scenario-----------------");
    }
    @Before(order=1)
    public void beforeScenario(){
        System.out.println("Start the browser and Clear the cookies");
        Helper.setUpDriver();
    }

    @After(order=0)
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    }
    @After(order=1)
    public void afterScenario(){
        System.out.println("close the browser");
        Helper.tearDown();
    }

}
