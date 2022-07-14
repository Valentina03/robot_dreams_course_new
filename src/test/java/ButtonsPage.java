import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ButtonsPage {
    private WebDriver driver;


    @BeforeClass
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void printTextAfterClickClickMeButton(){
        this.driver.navigate().to("https://demoqa.com/elements");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

        WebElement buttonsElement = driver.findElement(By.id("item-4"));
        buttonsElement.click();

        WebElement clickMeButton = this.driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();

        WebElement messageAfterClick = this.driver.findElement(By.id("dynamicClickMessage"));
        String getMessage = messageAfterClick.getText();
        assert "You have done a dynamic click".equals(getMessage);
        this.driver.quit();
    }
}