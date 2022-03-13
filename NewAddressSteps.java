package Zadanie1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;




public class NewAddressSteps {
    private WebDriver driver;

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/" + "index.php?controller=authentication");

    }

    @Given("User login in")
    public void LogIn() {
        WebElement emailInput =
                driver.findElement(By.name("email"));emailInput.sendKeys("DorotaPiotrowski@armyspy.com");

        WebElement passInput =
                driver.findElement(By.name("password"));passInput.sendKeys("Yohghohwee3");

        driver.findElement(By.id("submit-login")).click();
    }


    @When("User creates new address")
    public void CreateNewAddress() {
        driver.get("https://prod-kurs.coderslab.pl/" +
                "index.php?controller=addresses");
        driver.findElement(By.xpath("//*[@data-link-action='add-address']")).click();
    }

    @And("User type alias {string}")
    public void newAlias(String alias) {
        WebElement newAlias = driver.findElement(By.name("alias"));
        newAlias.clear();
        newAlias.sendKeys(alias);
    }

    @And("User type address {string}")
    public void newAddress(String address) {
        WebElement newAddress = driver.findElement(By.name("address1"));
        newAddress.clear();
        newAddress.sendKeys(address);
    }

    @And("User type zip {string}")
    public void newZip(String zip) {
        WebElement newZip = driver.findElement(By.name("postcode"));
        newZip.clear();
        newZip.sendKeys(zip);
    }
    @And("User type city {string}")
    public void newCity(String city) {
        WebElement newCity = driver.findElement(By.name("city"));
        newCity.clear();
        newCity.sendKeys(city);
    }
    @And("User type country {string}")
    public void newCountry(String country) {
        WebElement newCountry = driver.findElement(By.name("id_country"));
        newCountry.click();
        newCountry.sendKeys(country);
    }
    @And("User type phone number {string}")
    public void newPhone(String phone) {
        WebElement newPhone = driver.findElement(By.name("phone"));
        newPhone.clear();
        newPhone.sendKeys(phone);

    }
    @Then("User click Save Button")
    public void clickButton()  {
        WebElement clickButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        clickButton.click();
    }
    }