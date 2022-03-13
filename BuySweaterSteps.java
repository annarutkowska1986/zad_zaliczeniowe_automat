package Zadanie2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class BuySweaterSteps {
    private WebDriver driver;
    private File entirePageImageFile = new File("target/cucumber/screenshot.png");

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/" + "index.php?controller=authentication");

    }

    @Given("User login in to shop")
    public void LogIn() {
        WebElement emailInput =
                driver.findElement(By.name("email"));emailInput.sendKeys("DorotaPiotrowski@armyspy.com");

        WebElement passInput =
                driver.findElement(By.name("password"));passInput.sendKeys("Yohghohwee3");

        driver.findElement(By.id("submit-login")).click();
    }

    @When("User click clothes button")
    public void clothesButton() {
        WebElement clothesButton = driver.findElement(By.id("category-3"));
        clothesButton.click();
    }
    @And("User click: Hummingbird Printed Sweater")
    public void sweaterButton() {
        WebElement sweaterButton = driver.findElement(By.cssSelector("div.products.row"));
        sweaterButton.click();
    }

   @And("User choose {string} Size")
    public void choiceSize(String size){
       WebElement sizeButton = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
       sizeButton.click();
       Select roleDropDown = new Select(sizeButton);
       switch (size) {
           case "S":
               roleDropDown.selectByValue("1");
               break;
           case "M":
               roleDropDown.selectByValue("2");
               break;
           case "L":
               roleDropDown.selectByValue("3");
               break;
           case "XL":
               roleDropDown.selectByValue("4");
               break;
       }
   }


    @And("User choose {string} quantity")
    public void quantityButton(String quantity) throws InterruptedException {
        WebElement quantityButton = driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]"));
        Thread.sleep(4000);
        quantityButton.clear();
        quantityButton.sendKeys(quantity);
    }

    @And("User adds product to cart")
    public void toCartButton() {
        WebElement toCartButton = driver.findElement(By.cssSelector("div.add"));
        toCartButton.click();

    }
    @And("User goes to Shopping Cart")
    public void shoppCartButton() throws InterruptedException {
        WebElement shoppCartButton;
        Thread.sleep(4000);
        shoppCartButton = driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]"));
        shoppCartButton.click();

    }
    @And("User goes to checkout")
    public void checkoutButton() {
        WebElement checkoutButton = driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]"));
        checkoutButton.click();
    }
    @And("User confirms address")
    public void myAddressButton() {
        WebElement myAddressButton = driver.findElement(By.xpath("//*[@class=\"btn btn-primary continue float-xs-right\"]"));
        myAddressButton.click();
    }
    @And("User choose shipping method - pick up in store")
    public void shippMethodButton() {
        WebElement shippMethodButton = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
        shippMethodButton.click();
    }
    @And("User choose payment - Pay by Check")
    public void choosePayButton() {
        WebElement choosePayButton = driver.findElement(By.id("payment-option-1"));
        choosePayButton.click();
    }
    @And("User click agree to the term of service")
    public void agreeButton() {
        WebElement agreeButton = driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]"));
        agreeButton.click();
    }
    @And("User click order with an obligation to pay")
    public void clickOrderButton() {
        WebElement clickOrderButton = driver.findElement(By.xpath("//*[@class=\"btn btn-primary center-block\"]"));
        clickOrderButton.click();
    }

    @Then("User takes screenshot and saves price")
    public void screenshotEntirePageAshot() throws IOException {
        //Take Screenshot of entire page by AShot
        Screenshot entirePageScreenShot = new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        //Write Screenshot to a file
        ImageIO.write(entirePageScreenShot.getImage(),"PNG", entirePageImageFile);
    }
}
