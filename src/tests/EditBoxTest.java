package tests;

import models.Box;
import models.User;
import org.junit.Assert;
import org.junit.Test;

public class EditBoxTest extends BaseTest{

    @Override
    @Test
    public void secretSanta() throws InterruptedException {
        User user = new User("budrevichanya@gmail.com", "07072001Aa");
        app.open();

        app.getAuthHelper().signIn(user);
        app.getBoxHelper().openLastBox();
        app.getBoxHelper().openBoxEditor();

        Box newBox = new Box("EditedBox");
        app.getBoxHelper().editBox(newBox);
        app.getBoxHelper().openLastBox();
        Assert.assertEquals(app.getBoxHelper().getCreatedBoxData().getName(), newBox.getName());
        app.getAuthHelper().logout();
    }
}
