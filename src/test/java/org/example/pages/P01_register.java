package org.example.pages;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;

public class P01_register {
    public WebElement registerlink(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
    }
    public WebElement gender(){
        return Hooks.driver.findElement(By.id("gender-male"));
    }
    public WebElement firstNamePOM(WebDriver driver){
        return Hooks.driver.findElement(By.id("FirstName"));
    }
    public WebElement lastNamePOM(WebDriver driver){
        return Hooks.driver.findElement(By.id("LastName"));
    }
    public void nameInput(WebDriver driver, String firstName, String lastName){
        firstNamePOM(driver).clear();
        firstNamePOM(driver).sendKeys(firstName);
        lastNamePOM(driver).clear();
        lastNamePOM(driver).sendKeys(lastName);
    }
    public By brithDay(){
        return By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]/option[14]");
    }
    public By brithMonth(){
        return By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]/option[6]");
    }
    public By brithYear(){
        return By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]/option[91]");
    }
    public WebElement emailPOM(WebDriver driver){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[5]/input"));
    }
    public void enterEmail(WebDriver driver, String email){
        emailPOM(driver).sendKeys(email);
    }
    public WebElement passwordPOM(WebDriver driver){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[4]/div[2]/div[1]/input"));
    }
    public WebElement confPasswordPOM(WebDriver driver){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[4]/div[2]/div[2]/input"));
    }
    public void enterPassword(WebDriver driver, String password, String confPassword){
        passwordPOM(driver).clear();
        passwordPOM(driver).sendKeys(password);
        confPasswordPOM(driver).clear();
        confPasswordPOM(driver).sendKeys(confPassword);
    }
    public By registerBtn(){
        return By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[5]/button");
    }
    public By successMSG(){
        return By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]");
    }

}


