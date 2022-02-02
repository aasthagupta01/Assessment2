package assessment.pages;

import org.openqa.selenium.By;

public class HomePage {
    public static final By password = By.xpath("//*[@id=\"password\"]");
    public static final By userName = By.xpath("//*[@id=\"user-name\"]");
    public static final By login = By.xpath("//*[@id=\"login-button\"]");

    public static final By ProductName= By.xpath("//*[@id=\"item_4_title_link\"]/div");
    public static final By ProductPrice= By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");

    public static final By ADD_TO_CART= By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    public static final By In_CART= By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    public static final By CartProductName= By.xpath("//*[@id=\"item_4_title_link\"]/div");
    public static final By CartProductPrice= By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");

    public static final By Quantity= By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]");
    public static final By quantityafter= By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]");


    public static final By CHECKOUT=By.xpath("//*[@id=\"checkout\"]");
    public static final By FIRST_NAME= By.xpath("//*[@id=\"first-name\"]");
    public static final By LAST_NAME= By.xpath("//*[@id=\"last-name\"]");
    public static final By ZIP_CODE= By.xpath("//*[@id=\"postal-code\"]");
    public static final By CONTINUE= By.xpath("//*[@id=\"continue\"]");
    public static final By FINISH= By.xpath("//*[@id=\"finish\"]");


    public static String productbagName;
    public static String productbagprice;
    public static String quantitybefore;


}