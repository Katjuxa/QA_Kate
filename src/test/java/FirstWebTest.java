import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstWebTest {
    @Test
    public void firstWebTest() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HomePC\\Desktop\\Katja\\chromedriver_win32\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://delfi.lv");
    }


}
