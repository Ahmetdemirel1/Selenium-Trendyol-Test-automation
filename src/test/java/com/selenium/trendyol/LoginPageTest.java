package com.selenium.trendyol;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginPageTest extends PageTest {

    @Test
    public void login() {
        new LoginPage(driver).login("demirelahmet9@demirel.com","ahmet123");
    }
}