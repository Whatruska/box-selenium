package tests;// Generated by Selenium IDE
import models.Box;
import models.User;
import org.junit.Assert;
import org.junit.Test;

public class SecretSantaTest extends BaseTest{

  @Test
  public void secretSanta() throws InterruptedException {
    User user = new User("budrevichanya@gmail.com", "07072001Aa");
    Box box = new Box("New box");

    app.open();

    app.getAuthHelper().signIn(user);
    app.getBoxHelper().createBox(box);
    app.getBoxHelper().openLastBox();

    Assert.assertEquals(app.getBoxHelper().getCreatedBoxData().getName(), box.getName());
    app.getBoxHelper().deleteBox();

    app.getAuthHelper().logout();
  }


}