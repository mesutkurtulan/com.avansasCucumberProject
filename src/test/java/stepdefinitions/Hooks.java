package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {
    @Before
    public void setup(){
        //Driver.getDriver().get(ConfigReader.getProperty("avansas_home_url"));
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
