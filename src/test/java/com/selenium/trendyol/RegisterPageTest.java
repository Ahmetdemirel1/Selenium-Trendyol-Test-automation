package com.selenium.trendyol;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class RegisterPageTest extends PageTest {

    @Test
    public void register() {
        new RegisterPage(driver).register("demirelahmet9@demirel.com","ahmet123","erkek");
    }
}