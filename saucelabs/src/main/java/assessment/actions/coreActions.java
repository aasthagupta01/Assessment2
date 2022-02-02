package assessment.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class coreActions {

    protected final WebDriver bot;
    protected final WebDriverWait waiter;

    protected coreActions(WebDriver bot) {
        this.bot = bot;
        this.waiter = new WebDriverWait(bot, 10);
    }

    protected boolean waitForVisibility(By element) {
        boolean isVisible = true;
        try {
            waiter.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException te) {
            isVisible = false;
        }
        return isVisible;
    }

    protected void click(By element) {
        bot.findElement(element).click();
    }

    protected void enterText(By element, String text) {
        bot.findElement(element).sendKeys(text);
    }
    protected String textRetriever(By element){
        return bot.findElement(element).getText();
    }

    protected boolean dataMatcher(String data, By element){
        String text= textRetriever(element);
        System.out.println(text);

        if(text.equals(data)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void sleep(double sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}