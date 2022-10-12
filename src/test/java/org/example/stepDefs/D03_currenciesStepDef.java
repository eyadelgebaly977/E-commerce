package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    WebDriver driver;
    P03_homePage homePage=new P03_homePage(Hooks.driver);
    Select select=new Select(homePage.currency());
    @When("user Select Euro currency option from the dropdown list on the top left of home page")
    public void select_euro(){
        select.selectByVisibleText("Euro");
    }
    @Then("Euro Symbol is displayed on 4 product")
    public void euro_symbol(){
        int count=homePage.euroPrice().size();
        for (int i=0; i<count;i++){
            String symbol=homePage.euroSymbol().getText();
            Assert.assertTrue(symbol.contains("€"));
        }
    }
}
