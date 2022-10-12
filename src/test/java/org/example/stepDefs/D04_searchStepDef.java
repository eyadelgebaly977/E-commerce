package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.security.Key;

public class D04_searchStepDef {
    P03_homePage homepage=new P03_homePage();
    SoftAssert soft=new SoftAssert();

    @When("user click on search field")
    public void search_field(){
        homepage.searchField.click();
    }
    @And("^user search with \"([^\"]*)\"$")
    public void product_name_search(String text){
        homepage.searchField.sendKeys(text);
        homepage.searchField.sendKeys(Keys.ENTER);
    }
    @Then("^user could find \"([^\"]*)\"$")
    public void product_name_result(String word){
        String text=null;
        for (int i=0; i<homepage.productData().size();i++){
            text=homepage.productData().get(i).getText().toLowerCase();
        }
        soft.assertTrue(text.contains(word));
        String expected="https://demo.nopcommerce.com/search?q=";
        String actual=Hooks.driver.getCurrentUrl();
        soft.assertTrue(actual.contains(expected));
        soft.assertAll();
    }
    @Then("^user could find \"([^\"]*)\" in product details$")
    public void product_sku_result(String serial){
        homepage.selectProduct().click();
        String productSerial=homepage.product_serial().getText();
        Assert.assertTrue(serial.contains(productSerial));
    }
}
