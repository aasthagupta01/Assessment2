package core;

import assessment.com.Bot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class CoreTestIntegration {

    protected WebDriver bot;
    protected static final String URL = "https://www.saucedemo.com/";

    @BeforeClass
    public void openBrowser() {
        bot = new Bot().getBot();
        bot.get(URL);
    }

    protected static void logStep(String step) {
        Logger.step(step);
    }


//    @AfterClass
//    public void close() {
//        bot.quit();
//    }

}