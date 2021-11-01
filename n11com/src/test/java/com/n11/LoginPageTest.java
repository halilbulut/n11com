package com.n11;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;




public class LoginPageTest extends PageTest {

    @Test
    public void login() { new LoginPage(driver).login( "hallblt61@gmail.com" , "qwerty6123"); };

}
