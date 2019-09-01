import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstWebTest {
    @Test
    public void firstWebTest() {
        System.setProperty("webdriver.chrome.driver","C:/QA/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://delfi.lv");
    }


}
