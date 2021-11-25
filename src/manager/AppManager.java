package manager;

import helpers.AuthHelper;
import helpers.BoxHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppManager {

    private static ThreadLocal<AppManager> app = new ThreadLocal<>();
    private WebDriver driver;
    private JavascriptExecutor js;

    private AuthHelper authHelper;
    private BoxHelper boxHelper;

    private AppManager() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        authHelper = new AuthHelper(this);
        boxHelper = new BoxHelper(this);
    }

    public static AppManager getInstance() {
        if (app.get() == null) {
            AppManager manager = new AppManager();
            app.set(manager);
        }
        return app.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public AuthHelper getAuthHelper() {
        return authHelper;
    }

    public BoxHelper getBoxHelper() {
        return boxHelper;
    }

    public void open(){
        driver.get("https://santa-secret.ru/");
        driver.manage().window().setSize(new Dimension(1584, 1040));
    }

    public void stop() {
        driver.quit();
    }
}
