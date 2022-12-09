import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged() == false) {
            app.getUser()
                    .login(new User()
                            .withEmail("asd@fgh.com")
                            .withPassword("$Asdf1234")
                    );
            app.getUser().pause(10);
            app.getUser().clickOkButton();
        }
    }

    @Test
    public void addNewCarPositive() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        Car car = Car.builder()
                .address("Tel Aviv")
                .make("KIA")
                .model("Sportage")
                .year("2020")
                .fuel("Petrol")
                .seats("4")
                .carClass("5")
                .carRegNumber("100-200-" + i)
                .price("150")
                .build();

        app.getCar().openCarForm();
        Assert.assertTrue(app.getCar().isCarFormPresent());
//        app.getCar().fillCarForm();
//        app.getCar().submitForm();

    }

//    @AfterMethod
}
