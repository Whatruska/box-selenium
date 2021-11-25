package helpers;

import models.User;
import manager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AuthHelper extends BaseHelper {
    public AuthHelper(AppManager manager) {
        super(manager);
    }

    public void logout() throws InterruptedException {
        WebElement elem = driver.findElement(By.cssSelector(".header-item__text:nth-child(1) > .txt--med"));
        js.executeScript("arguments[0].click()", elem);
        Thread.sleep(500);
        {
            WebElement element = driver.findElement(By.cssSelector(".header-item__text:nth-child(1) > .txt--med"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".base--clickable > .txt--med")).click();
        Thread.sleep(5000);
    }

    public void signIn(User user) throws InterruptedException {
        driver.findElement(By.cssSelector(".layout-1__header-wrapper-fixed .header__items .txt--med")).click();
        driver.findElement(By.cssSelector(".frm-wrapper:nth-child(3) > .frm")).click();
        driver.findElement(By.cssSelector(".frm-wrapper:nth-child(3) > .frm")).sendKeys(user.getEmail());
        driver.findElement(By.cssSelector(".frm-wrapper:nth-child(4) > .frm")).click();
        driver.findElement(By.cssSelector(".frm-wrapper:nth-child(4) > .frm")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector(".btn-main.base--clickable")).click();
        Thread.sleep(3000);
    }
}
