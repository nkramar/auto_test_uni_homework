import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Lesson3_Way2AutomationTests {

  private WebDriver chromeDriver;

  @BeforeEach
  public void setup() {
    WebDriverManager.chromedriver().setup();
    chromeDriver = new ChromeDriver();
    chromeDriver.manage().window().maximize();

  }

  @Test
  @DisplayName("Test for practice for CSS and XPath usage")
  public void registrationFormTest() {
    chromeDriver.navigate().to("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
    chromeDriver.findElement(By.name("name")).sendKeys("Petr");
    chromeDriver.findElement(By.cssSelector("p:nth-child(2) > input")).sendKeys("Petrov");
    chromeDriver.findElement(By.xpath("//label[normalize-space()='Single']")).click();
    chromeDriver.findElement(By.xpath("//label[normalize-space()='Reading']")).click();
    chromeDriver.findElement(By.cssSelector("fieldset:nth-child(4) > select")).click();
    chromeDriver.findElement(By.cssSelector("fieldset:nth-child(4) > select")).findElement(By.xpath("//option[.='India']")).click();
    chromeDriver.findElement(By.cssSelector(".time_feild:nth-child(2) > select")).click();
    chromeDriver.findElement(By.cssSelector(".time_feild:nth-child(2) > select")).findElement(By.xpath("//option[.='1']")).click();
    chromeDriver.findElement(By.cssSelector(".time_feild:nth-child(3) > select")).click();
    chromeDriver.findElement(By.cssSelector(".time_feild:nth-child(3) > select")).findElement(By.xpath("//option[.='1']")).click();
    chromeDriver.findElement(By.cssSelector(".time_feild:nth-child(4) > select")).click();
    chromeDriver.findElement(By.cssSelector(".time_feild:nth-child(4) > select")).findElement(By.xpath("//option[.='2014']")).click();
    chromeDriver.findElement(By.name("phone")).sendKeys("12345678910");
    chromeDriver.findElement(By.name("username")).sendKeys("petr_petrov");
    chromeDriver.findElement(By.name("email")).sendKeys("petr_petrov@gmail.com");
    File file = new File("src/test/resources/avatar.png");
    chromeDriver.findElement(By.xpath("//input[@type='file']")).sendKeys(file.getAbsolutePath());
    //chromeDriver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\avatar.png");
    chromeDriver.findElement(By.cssSelector("textarea")).sendKeys("Hello, I'm Petr Petrov!");
    chromeDriver.findElement(By.name("password")).sendKeys("12345");
    chromeDriver.findElement(By.name("c_password")).sendKeys("12345");
    chromeDriver.findElement(By.cssSelector("input[type='submit']")).click();


  }

  @AfterEach
  public void stop() {
    chromeDriver.quit();
    chromeDriver = null;
  }
}
