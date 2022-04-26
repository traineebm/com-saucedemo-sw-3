package testsuite;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Finding the username field element
        sendTextToElement(By.id("user-name"),"standard_user");
        // Finding the password field element
        sendTextToElement(By.id("password"),"secret_sauce");
        // Finding the login button and clicking on it
        clickOnElement(By.name("login-button"));
        
        //Validate expected and actual text message
        verifyElements("Text is not matching","PRODUCTS",By.xpath("//span[contains(text(),'Products')]"));
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Finding the username field element
        sendTextToElement(By.id("user-name"),"standard_user");
        // Finding the password field element
        sendTextToElement(By.id("password"),"secret_sauce");
        // Finding the login button and clicking on it
        clickOnElement(By.name("login-button"));

        //Verifying the given text from the requirements
        // Verifying that six products are displayed on page
        int expectedNumberOfProducts = 6;
        List<WebElement> actualNumberOfProducts = driver.findElements(By.className("inventory_item"));
        int totalNumberOfProducts = actualNumberOfProducts.size();

        //Validate expected and actual text message
        Assert.assertEquals("Six products not displayed",expectedNumberOfProducts,totalNumberOfProducts );
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

