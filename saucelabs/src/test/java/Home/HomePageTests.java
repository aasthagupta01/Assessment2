package Home;

import assessment.actions.HomePageImpl;
import core.CoreTestIntegration;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class HomePageTests extends CoreTestIntegration {

    HomePageImpl home;

    @Test
    @Description("creating impl objects before class")
    public void initImpl() {
        home = new HomePageImpl(bot);
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("test that the user is valid")
    @Severity(SeverityLevel.CRITICAL)
    @Story("STORY 1")
    @Feature("FEATURE 1")
    @Owner("Aastha Gupta")
    public void test_assignment() {

        logStep("Entered the username and password");
        home.Username();

        logStep("Login");
        home.Login();

        logStep("Adding item to cart");
        home.addToCart();

        logStep("In cart");
        home.inCart();

        logStep("Verification of product name");
        home.nameCheck();

        logStep("verification of product price");
        home.priceCheck();

        logStep("Clicked on checkout");
        home.checkout();

        logStep("Entered FirstName");
        home.firstname("Tehrim");

        logStep("Entered LastName");
        home.lastname("Ansari");

        logStep("Entered Zipcode");
        home.zipCode("140507");

        logStep("Clicked on continue");
        home.continueshopping();

        logStep("Clicked on finish");
        home.finish();

//        logStep("Verification of cart after placing order");
//        home.BackToCart();

    }


}