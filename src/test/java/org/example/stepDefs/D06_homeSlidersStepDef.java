package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.logging.SocketHandler;

public class D06_homeSlidersStepDef {
    WebDriver driver;
    P03_homePage homePage=new P03_homePage();
    @When("user choose on Nokia slider")
    public void choose_nokia_slider(){
        Hooks.driver.findElement(homePage.nokiaSliderChoose()).click();
    }
    @And("user click on Nokia slider")
    public void click_nokia_slider(){
        homePage.sliderClick("1").click();
    }
    @Then("user navigate to Nokia URL")
    public void navigates_nokia_url() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020","Bug found in nokia URL");
    }
    @When("user choose on iphone slider")
    public void choose_iphone_slider(){
        Hooks.driver.findElement(homePage.iphoneSliderChoose()).click();
    }
    @And("user click on iphone slider")
    public void click_iphone_slider(){
        homePage.sliderClick("2").click();
    }
    @Then("user navigate to iphone URL")
    public void navigate_iphone_url() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6","Bug found in iphone URL");
    }
}
