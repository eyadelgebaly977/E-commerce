package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_homePage {

    public P03_homePage(){
        PageFactory.initElements(Hooks.driver,this);
    }
    WebDriver driver;
    public P03_homePage(WebDriver driver){
        this.driver=driver;
    }
    //Currency change and Assertion
    public WebElement currency(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[1]/div/select"));
    }
    public WebElement euroSymbol(){
        return driver.findElement(By.cssSelector("span[class=\"price actual-price\"]"));
    }
    public List euroPrice(){
        return driver.findElements(By.xpath("/html/body/div[6]/div[1]/div[1]/div[1]/div/select/option[2]"));
    }

    //search
    @FindBy(id="small-searchterms")
    public WebElement searchField;
    @FindBy(className = "button-1 search-box-button")
    public WebElement searchBtn;

    public List<WebElement> productName(){
        List<WebElement> product=driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/h2"));
        return product;
    }
    public List<WebElement> productData(){
        List<WebElement> data=driver.findElements(By.className("item-box"));
        return data;
    }
    public WebElement selectProduct(){
        WebElement element=Hooks.driver.findElement(By.className("picture"));
        return element;
    }
    public WebElement product_serial(){
        WebElement element=Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"]>span[class=\"value\"]"));
        return element;
    }
}
