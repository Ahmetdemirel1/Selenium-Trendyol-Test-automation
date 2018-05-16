package com.selenium.trendyol;

import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public LoginPage(WebDriver driver){
        this.webDriver = driver;
        this.webDriverWait = new WebDriverWait(webDriver, 30, 150); // bizim icin bekleme olayi yaratti bu olmadiginda menu ecilmadan sornaki adimlara geciyor ve hata donduruyor
    }

    public void login(String email, String password){

        webDriver.get("https://www.trendyol.com/");
        webDriver.findElement(By.cssSelector(".fancybox-item.fancybox-close")).click();
        openLoginRegisterMenu();

        //webDriver.findElement(By.cssSelector(".account-button.register")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".account-button.login"))).click();
        webDriver.findElement(By.id("email")).sendKeys(email);
        webDriver.findElement(By.id("password")).sendKeys(password);

        webDriver.findElement(By.id("loginSubmit")).click();
        openLoginRegisterMenu();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".login-register-button-container"))).click();
        List<WebElement> webElements = webDriver.findElements(By.cssSelector(".account-link"));
        webElements.get(1).click();

        String elementval = webDriver.findElement(By.id("UserModel_Email")).getAttribute("value");

        Assert.assertEquals("E-mail Adresi Doğu Değil!!!",email,elementval);





    }


    public void openLoginRegisterMenu(){
        WebElement mainLoginButton = webDriver.findElement(By.cssSelector(".icon.icon-user"));
        //mainLoginButton.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(mainLoginButton).build().perform();
    }


}