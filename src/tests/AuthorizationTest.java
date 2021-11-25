package tests;

import models.User;
import org.junit.Test;

public class AuthorizationTest extends BaseTest{

    @Test
    public void secretSanta() throws InterruptedException {
        User user = new User("budrevichanya@gmail.com", "07072001Aa");
        app.open();

        app.getAuthHelper().signIn(user);
        app.getAuthHelper().logout();
    }
}

