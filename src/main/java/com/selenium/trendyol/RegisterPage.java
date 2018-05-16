package com.selenium.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegisterPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public RegisterPage(WebDriver driver){
        this.webDriver = driver;
        this.webDriverWait = new WebDriverWait(webDriver, 30, 150); // bizim icin bekleme olayi yaratti bu olmadiginda menu ecilmadan sornaki adimlara geciyor ve hata donduruyor



    }


    public void register(String email, String password, String gender){


        webDriver.get("https://www.trendyol.com/");
        webDriver.findElement(By.cssSelector(".fancybox-item.fancybox-close")).click();
        openLoginRegisterMenu();

        //webDriver.findElement(By.cssSelector(".account-button.register")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".account-button.register"))).click();

        webDriver.findElement(By.id("email")).sendKeys(email);
        webDriver.findElement(By.id("password")).sendKeys(password);
        if(gender == "erkek"){
            webDriver.findElement(By.cssSelector(".gender-type-button.man-shoes")).click();
        }
        else {
            webDriver.findElement(By.cssSelector("gender-type-button.woman-shoes.active")).click();
        }
        List<WebElement> webElements = webDriver.findElements(By.cssSelector(".checkbox-label"));
        webElements.get(0).click();

        webDriver.findElement(By.id("registerSubmit")).click();





    }

    public void openLoginRegisterMenu(){
        WebElement mainLoginButton = webDriver.findElement(By.cssSelector(".icon.icon-user"));
        //mainLoginButton.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(mainLoginButton).build().perform();
    }



}
