import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DelfiArticleTest {

    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[@class='comment-count text-red-ribbon']");

    @Test
    public void titleAnsCommentsTest() {

        //Open browser
        System.setProperty("webdriver.chrome.driver", "C:/Users/HomePC/Desktop/Katja/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Delfi Home page
        driver.get("http://rus.delfi.lv");

        //Find 1st article title
        WebElement homePageTitle = driver.findElement(HOME_PAGE_TITLE);

        //Save to String
        String TitleToCompare = homePageTitle.getText();

        //Find comments count
        WebElement homePageComments = driver.findElement(HOME_PAGE_COMMENTS);

        //Save to Integer
        String commentsToParse = homePageComments.getText(); //(1)
        commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1);
        Integer commentsToCompare = Integer.valueOf(commentsToParse);


        //Open Article page
        //Find article title
        //Check title
        //Find comment count
        // Check comment count
        //Open comments page
        //Find title
        //Check title
        //Get comment count
        //Check comment count
        //Close browser
    }
}
