package org.example.stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    WebDriver driver;
    P01_register register=new P01_register();

    @Given("user go to register page")
    public void goRegisterPage(){
        register.registerlink().click();
    }
    @When("user select gender type")
    public void gender_type(){
        register.gender().click();
    }
    @And("user enter first name \"automation\" and last name \"tester\"")
    public void enterName(){
        register.nameInput(driver,"automation","tester");
    }
    @And("user enter date of birth")
    public void date_of_brith(){
        Hooks.driver.findElement(register.brithDay()).click();
        Hooks.driver.findElement(register.brithMonth()).click();
        Hooks.driver.findElement(register.brithYear()).click();
    }
    @And("user enter email \"test@example.com\" field")
    public void enter_email(){
        register.enterEmail(driver,"eyadsherif@gmail.com");
    }
    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void fills_password(){
        register.enterPassword(driver,"P@ssw0rd","P@ssw0rd");
    }
    @And("user clicks on register button")
    public void register_button(){
        Hooks.driver.findElement(register.registerBtn()).click();
    }
    @Then("success message is displayed")
    public void success_message(){
        SoftAssert soft=new SoftAssert();
        String expectedResult="Your registration completed";
        String actualResult=Hooks.driver.findElement(register.successMSG()).getText();
        soft.assertTrue(actualResult.contains(expectedResult));
        String color=Hooks.driver.findElement(By.className("result")).getCssValue("color");
        System.out.println("Color: "+color);
        soft.assertAll();
    }
}
