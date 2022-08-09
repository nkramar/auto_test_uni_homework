import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.*;


public class Lesson10_HW_WindowsAndDialogs {

  private WebDriver chromeDriver;
  private final String baseURL = "http://omayo.blogspot.com/";

  @BeforeEach
  public void setUpDriver() {

    WebDriverManager.chromedriver().setup();
    chromeDriver = new ChromeDriver();
    chromeDriver.manage().window().maximize();
    chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @Test
  @DisplayName("Working with frames methods")

  public void openFrameTest() {

    chromeDriver.get(baseURL + "p/page6.html");

    chromeDriver.switchTo().frame("dateFrame");
    chromeDriver.switchTo().frame(chromeDriver.findElement(By.className("demo-frame")));
    chromeDriver.findElement(By.id("datepicker")).click();
    WebElement element = chromeDriver.findElement(By.id("ui-datepicker-div"));
    Assertions.assertTrue(element.isDisplayed());

  }

  @Test
  @DisplayName("Open new window and switch between opened windows")

  public void openNewWindowAndSwitchTest() {

    chromeDriver.get(baseURL);

    String initialWindow = chromeDriver.getWindowHandle();

    chromeDriver.switchTo().newWindow(WindowType.WINDOW);

    assert !chromeDriver.getWindowHandle().equals(initialWindow);

    chromeDriver.switchTo().window(initialWindow);

    assert chromeDriver.getWindowHandle().equals(initialWindow);
  }


  @Test
  @DisplayName("Open new Tab and check it's title")
  public void openNewTab() {
    chromeDriver.get(baseURL);
    WebDriver newTab = chromeDriver.switchTo().newWindow(WindowType.TAB);
    newTab.get(baseURL + "p/page6.html");
    Assertions.assertEquals("omayo (QAFox.com): Page6", newTab.getTitle());
  }

  @AfterEach
  public void closeBrowser() {
    chromeDriver.quit();
    chromeDriver = null;
  }

}

