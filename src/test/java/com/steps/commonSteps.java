package com.steps;

import com.helper.connectionHelper;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.jvm.hotspot.utilities.Assert;

import java.util.List;
import java.util.Set;

/**
 * Created by v-fennev-ave on 7/10/15.
 */
public class commonSteps {

    connectionHelper helper = new connectionHelper();

    @Given("^User opens \"([^\"]*)\"$")
    public void User_opens(String page) throws Throwable {
        helper.goToPage(page);
    }

    @When("^User searches for \"([^\"]*)\" on \"([^\"]*)\"$")
    public void Search_On_Element(String input, String element) throws Throwable {
        helper.getDriver().findElement(By.id(element)).sendKeys(input);

    }

    @Then("^\"([^\"]*)\" should contain \"([^\"]*)\"$")
    public void Element_Contains_Output(String element, String output) throws Throwable {
        Assert.that(helper.getDriver().findElement(By.id(element)).getAttribute("href").contains("car"), "Ugly Assert ok");
    }


}
