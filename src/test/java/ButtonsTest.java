import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ButtonsTest {
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
    public void openButtonsPageTest(){
        this.driver.navigate().to("https://demoqa.com/elements");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        WebElement buttonsElement = driver.findElement(By.id("item-4"));
        buttonsElement.click();
        assert "https://demoqa.com/buttons".equals(driver.getCurrentUrl());
    }

    @Test
    public void printTextAfterClickingClickMeButtonTest(){
        openButtonsPageTest();

        WebElement clickMeButton = this.driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();
        WebElement messageAfterClicking = this.driver.findElement(By.id("dynamicClickMessage"));
        String getMessage = messageAfterClicking.getText();
        System.out.println(getMessage);
        assert "You have done a dynamic click".equals(getMessage);
    }
}