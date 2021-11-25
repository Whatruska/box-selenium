package helpers;

import models.Box;
import manager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BoxHelper extends BaseHelper {

    public BoxHelper(AppManager manager) {
        super(manager);
    }

    public void createBox(Box box) throws InterruptedException {
        WebElement btn = driver.findElement(By.cssSelector(".btn-main > span.txt-buttons"));
        js.executeScript("arguments[0].click()", btn);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".frm-wrapper:nth-child(1) > .frm")).sendKeys(box.getName());
        driver.findElement(By.cssSelector(".btn-arrow-right")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".btn-arrow-right")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".btn-arrow-right")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".btn-arrow-right")).click();
        Thread.sleep(1000);
    }

    public void deleteBox() throws InterruptedException {
        WebElement elem = driver.findElement(By.cssSelector(".toggle-menu-button--inner"));
        js.executeScript("arguments[0].click()", elem);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".layout-1__header-wrapper-fixed .base--clickable:nth-child(5) > .txt--med")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".form-page-group:nth-child(2) .frm")).click();
        driver.findElement(By.cssSelector(".form-page-group:nth-child(2) .frm")).sendKeys("Удалить коробку");
        driver.findElement(By.cssSelector(".btn-service")).click();
        Thread.sleep(2000);
    }

    public void openLastBox() throws InterruptedException {
        driver.findElement(By.cssSelector("#root > div > section.layout-1__header-wrapper-fixed > header > section > div > div > a:nth-child(1)")).click();
        Thread.sleep(1000);
        List<WebElement> elems = driver
                .findElement(By.cssSelector("#root > div > section.layout-1__main-wrapper > div.layout-1__main > section > div:nth-child(2) > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-2 > div > div"))
                .findElements(By.className("base--clickable"));
        elems.get(elems.size() - 1).click();
        Thread.sleep(2000);
    }

    public Box getCreatedBoxData() {
        String name = driver
                .findElement(By.cssSelector("#root > div.layout-1 > section.layout-1__header-wrapper-fixed > div.layout-1__header-secondary.header-secondary-wrapper.header-secondary-wrapper--shadow > section > div.header-secondary__left-item > div > div.box-header-info__wrapper > span"))
                .getText();
        return new Box(name);
    }

    public void openBoxEditor() throws InterruptedException {
        WebElement elem = driver.findElement(By.cssSelector(".toggle-menu-button--inner"));
        js.executeScript("arguments[0].click()", elem);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#root > div.layout-1 > section.layout-1__header-wrapper-fixed > div.layout-1__header-secondary__menu.header-secondary-menu--wrapper > section > div.organizer-menu.organizer-menu--opened > div.organizer-menu__wrapper > div:nth-child(4) > span.txt--med.txt")).click();
        Thread.sleep(2000);
    }

    public void editBox(Box newBox) throws InterruptedException{
        WebElement input = driver.findElement(By.cssSelector("#root > div.layout-1 > section.layout-1__main-wrapper > div.layout-1__main > section > div > section > div > div > div.form-page__main > div:nth-child(1) > div.form-page-group__main > div > input"));
        input.click();
        input.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        input.sendKeys(newBox.getName());
        WebElement submitBtn = driver.findElement(By.cssSelector("#root > div.layout-1 > section.layout-1__main-wrapper > div.layout-1__main > section > div > section > div > div > div.form-page__footer > div > div.btn-main.base--clickable.btn--no-wrap"));
        Thread.sleep(100);
        submitBtn.click();
        Thread.sleep(2000);
    }
}
