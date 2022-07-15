import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTablesPageTest {
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
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("Valya");
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Konovalenko");
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("konovalenko@gmail.com");
        WebElement ageInput = driver.findElement(By.id("age"));
        ageInput.sendKeys("25");
        WebElement salaryInput = driver.findElement(By.id("salary"));
        salaryInput.sendKeys("10000");
        WebElement departmentInput = driver.findElement(By.id("department"));
        departmentInput.sendKeys("QA");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        //проверяем что запись добавилась
        WebElement newRecording = driver.findElement(By.xpath("//div[text()='konovalenko@gmail.com']"));
    }

    @Test
    public void editRecordingTest(){
        addNewRecordingTest();
        WebElement editButton = driver.findElement(By.xpath("//div[text()='konovalenko@gmail.com']/../div//span[@title='Edit']"));
        editButton.click();
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Mikhailova");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement updateRecording = driver.findElement(By.xpath("//div[text()='Mikhailova']"));
    }
}
