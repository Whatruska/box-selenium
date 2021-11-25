package helpers;

import manager.AppManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

abstract public class BaseHelper {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected AppManager manager;

    public BaseHelper(AppManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
        this.js = manager.getJs();
    }
}
