import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTablesPage {
    private WebDriver driver;

    @BeforeClass
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void quitDriver(){
        this.driver.quit();
    }

    @Test
    public void addNewRecordingTest(){
        this.driver.navigate().to("https://demoqa.com/webtables");
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();
    }

    @Test
    public void editRecordingTest(){}
}
