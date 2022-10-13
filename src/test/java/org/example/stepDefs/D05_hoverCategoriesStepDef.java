package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class D05_hoverCategoriesStepDef {
    WebDriver driver;
    P03_homePage homePage=new P03_homePage();


    @Given("user hover categories")
    public void hover(){
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(homePage.aparelHover()).perform();
        action.moveToElement(homePage.electronicsHover()).perform();
        action.moveToElement(homePage.computerHover()).perform();


    }
    @When("user click on subcategory")
    public void click_subcategory(){
        Hooks.driver.findElement(homePage.desktopSub()).click();
    }
    @And("user go to product page")
    public void product_page(){
        String expected="Desktops";
        String actual=Hooks.driver.findElement(homePage.pageTitle()).getText();
        Assert.assertTrue(actual.contains(expected));
    }
}
