package com.n11;



import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;




public class LoginPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 30, 150);
    }

    @Test
///giris
    public void login(String username, String password) {
        webDriver.get("https://www.n11.com/");
        Assert.assertEquals("n11.com - Hayat Sana Gelir", webDriver.getTitle());
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className("btnSignIn"))).click();
        Assert.assertEquals("Giriş Yap - n11.com", webDriver.getTitle());
        webDriver.findElement(By.id("email")).clear();
        webDriver.findElement(By.id("email")).sendKeys(username);
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton"))).click();
        Assert.assertEquals("n11.com - Hayat Sana Gelir", webDriver.getTitle());
    }

    @Test
////arama
    public void Test1() {
        WebElement searchData = webDriver.findElement(By.id("searchData"));
        searchData.sendKeys("Bilgisayar");
        searchData.sendKeys(Keys.ENTER);
    }

    @Test
////ikinci sayfa geçiş
    public void Test2() {
        webDriver.findElement(By.id("a.next.navigation")).click();
        Assert.assertEquals("Bilgisayar - n11.com", webDriver.getTitle());
    }

    @Test
////rastgele ürün seçme,sepete ekleme, karsilastirma
    public void Test3() {
        webDriver.findElement(By.id("div.pro")).click();
        webDriver.findElement(By.id("a.btn.btnGrey.btnAddBasket")).click();
        webDriver.findElement(By.id("i.icon.iconBasket")).click();
        Assert.assertEquals("ins", "span");
    }

    @Test
////ürün arttırma, sepet silme
    public void Test4() {
        webDriver.findElement(By.id("span.spinnerUp.spinnerArrow")).click();
        webDriver.findElement(By.id("span.remove.Prod.svglcon.svglcon_trash")).click();
        Assert.assertEquals("Sepetiniz Boş", webDriver.getTitle());
    }
}



