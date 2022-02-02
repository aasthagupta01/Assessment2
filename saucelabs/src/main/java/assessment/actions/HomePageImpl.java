package assessment.actions;

//import assessment.pages.Cart;
import assessment.pages.HomePage;
import io.qameta.allure.Step;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class HomePageImpl extends coreActions {

    public HomePageImpl(WebDriver bot)
    {
        super(bot);
    }

    @Step("username")
    public void Username() {
        waitForVisibility(HomePage.userName);

        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder= factory.newDocumentBuilder();

            Document document=builder.parse(new File("data.xml"));

            document.getDocumentElement().normalize();

            NodeList datalist=document.getElementsByTagName("user");
            for(int i =0; i<1;i++)
            {
                Node data= datalist.item(i);
                if(data.getNodeType() == Node.ELEMENT_NODE) {

                    Element dataElement = (Element) data;
                    enterText(HomePage.userName, dataElement.getAttribute("name"));

                    NodeList userDetails =  data.getChildNodes();
                    for(int j = 0; j < userDetails.getLength(); j++){
                        Node detail = userDetails.item(j);
                        if(detail.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element) detail;
                            enterText(HomePage.password, detailElement.getAttribute("value"));
                        }

                    }


                }

            }


        }catch (ParserConfigurationException e)
        {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
//    @Step("password")
//    public void Password(final String password) {
//        waitForVisibility(HomePage.password);
//        enterText(HomePage.password, password);
//    }

    @Step("Login")
    public void Login() {
        waitForVisibility(HomePage.login);
        click(HomePage.login);
    }

    @Step("Add to cart")
    public void addToCart() {
//        waitForVisibility(HomePage.ADD_TO_CART);
        sleep(0.50);


        HomePage.productbagName=textRetriever(HomePage.ProductName);
        HomePage.productbagprice=textRetriever(HomePage.ProductPrice);

        click(HomePage.ADD_TO_CART);
    }

    @Step("In Cart")
    public void inCart() {
        waitForVisibility(HomePage.In_CART);
        click(HomePage.In_CART);
    }

    @Step("for order placing")
    public void checkout() {
        waitForVisibility(HomePage.CHECKOUT);
        HomePage.quantitybefore=textRetriever(HomePage.Quantity);
        click(HomePage.CHECKOUT);
    }
    @Step("First Name")
    public void firstname(final String name) {
//        waitForVisibility(HomePage.FIRST_NAME);
        sleep(0.50);
        enterText(HomePage.FIRST_NAME, name);
    }

    @Step("Last Name")
    public void lastname(final String lname) {
//        waitForVisibility(HomePage.LAST_NAME);
        sleep(0.50);
        enterText(HomePage.LAST_NAME, lname);
    }
    @Step("Zip Code")
    public void zipCode(final String code)
    {
//        waitForVisibility(HomePage.ZIP_CODE);
        sleep(0.50);
        enterText(HomePage.ZIP_CODE, code);
    }

    @Step("Continue for shopping")
    public void continueshopping() {
        waitForVisibility(HomePage.CONTINUE);
        click(HomePage.CONTINUE);
    }

    @Step("Finish Shopping")
    public void finish() {
//        waitForVisibility(HomePage.FINISH);
        sleep(0.50);
        click(HomePage.FINISH);
    }


    @Step("Verifying the Product Name")
    public void nameCheck(){

        Assert.assertTrue(dataMatcher(HomePage.productbagName, HomePage.CartProductName));
        System.out.println("Name checking complete");
    }

    @Step("Verifying the Product Price")
    public void priceCheck(){

        Assert.assertTrue(dataMatcher(HomePage.productbagprice, HomePage.CartProductPrice));
        System.out.println("Price checking completed");
    }

    @Step("In Cart")
    public void BackToCart() {
        waitForVisibility(HomePage.In_CART);
        click(HomePage.In_CART);
        Assert.assertFalse(dataMatcher(HomePage.quantitybefore, HomePage.quantityafter));
        System.out.println("Cart checking completed after placing order");

    }

}