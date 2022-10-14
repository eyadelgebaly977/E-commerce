package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDef {
    WebDriver driver;
    P03_homePage homePage=new P03_homePage();
    SoftAssert soft=new SoftAssert();

    @When("User click on wishlist button of HTC One M8 Android L 5.0 Lollipop")
    public void htc_wishlist_click(){
        homePage.htcWishlist().click();
    }
    @Then("Success MSG appears")
    public void success_MSG(){
        String expected="The product has been added to your wishlist";
        String actual=Hooks.driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p")).getText();
        soft.assertTrue(actual.contains(expected),"Bug found in adding product to wishlist");
        String color=Hooks.driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div")).getCssValue("background-color");
        soft.assertEquals(color,"rgba(75, 176, 122, 1)");
        System.out.println("Background color: "+color);
        soft.assertAll();
    }
    int valueInt;
    @And("user get Qty value and verify that it is <0")
    public void Qty_value() throws InterruptedException {
        Thread.sleep(5000);
        String valueString=homePage.qtyValue().getText();
        valueString= valueString.replaceAll("[^0-9]","");
        valueInt = Integer.parseInt(valueString);
        System.out.println(valueInt);
    }
    @Then("no. of wishlist inc.")
    public void qtaNotEqual0(){
        soft.assertTrue(valueInt>0);
    }
}
