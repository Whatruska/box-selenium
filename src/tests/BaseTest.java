package tests;

import manager.AppManager;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public abstract class BaseTest {
    
    protected AppManager app;

    public abstract void secretSanta() throws InterruptedException;

    @Before
    public void setUp() {
        app = AppManager.getInstance();
    }
}
