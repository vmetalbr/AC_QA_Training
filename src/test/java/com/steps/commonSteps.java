package com.steps;

import com.helper.connectionHelper;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.ScenarioResult;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import sun.jvm.hotspot.utilities.Assert;

/**
 * Created by v-fennev-ave on 7/10/15.
 */
public class commonSteps {

    connectionHelper helper = new connectionHelper();

    @Before
    public void start(){
        helper.startDriver();
    }

    @After
    public void end(ScenarioResult scenario){
        helper.embedScreenshot(scenario);
        helper.stopDriver();
    }

    @Given("^User opens \"([^\"]*)\"$")
    public void User_opens(String page) throws Throwable {
        helper.goToPage(page);
    }

    @When("^User searches for \"([^\"]*)\" on \"([^\"]*)\"$")
    public void Search_On_Element(String input, String element) throws Throwable {
        helper.getDriver().findElement(By.id(element)).sendKeys(input + Keys.ENTER);

    }

    @Then("^\"([^\"]*)\" should contain \"([^\"]*)\"$")
    public void Element_Contains_Output(String element, String output) throws Throwable {
        Assert.that(helper.getDriver().findElement(By.id(element)).getAttribute("value").contains(output), "Ugly Assert ok");
    }


}
