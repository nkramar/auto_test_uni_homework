import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Lesson7Waits {

  private WebDriver chromeDriver;
  private WebDriverWait wait;

  @BeforeEach
  public void setUpDriver() {

    WebDriverManager.chromedriver().setup();
    chromeDriver = new ChromeDriver();
    chromeDriver.manage().window().maximize();
    chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @Test
  @DisplayName("Search element using implicitly and explicitly waits ")
  public void searchElement() {

    chromeDriver.get("https://www.way2automation.com/way2auto_jquery/index.php");
    wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("load_box")));
    Assertions.assertTrue(element.isDisplayed());

  }

  @Test
  @DisplayName("Search and accept alert element using implicitly and explicitly waits ")
  public void searchAlertElement() {

    chromeDriver.get("https://demoqa.com/alerts");
    chromeDriver.findElement(By.id("timerAlertButton")).click();
    wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.alertIsPresent());
    chromeDriver.switchTo().alert().accept();

  }

  @AfterEach
  public void closeBrowser() {
    chromeDriver.quit();
    chromeDriver = null;
  }
}
