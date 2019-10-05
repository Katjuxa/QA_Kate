import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DelfiArticleTest {

    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[@class='comment-count text-red-ribbon']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-md-30'")]);
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'text-size-19')"]);
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[@class = 'article-title']/a");
    private final By ARTICLE = By.xpath(".//span[@class = 'text-size-22 d-block']")



    @Test
    public void titleAnsCommentsTest() {

        //Open browser
        System.setProperty("webdriver.chrome.driver", "C:/Users/HomePC/Desktop/Katja/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Delfi Home page
        driver.get("http://rus.delfi.lv");

        //Find 1st Article
        WebElement article = driver.findElements(ARTICLE).get(0);

        //Find 1st article title
//        WebElement homePageTitle = driver.findElement(HOME_PAGE_TITLE);
        WebElement homePageTitle = article.findElement(HOME_PAGE_TITLE);

        //Save to String
        String titleToCompare = homePageTitle.getText();

        //Find comments count
//        WebElement homePageComments = driver.findElement(HOME_PAGE_COMMENTS);
        Integer commentsToCompare = 0;

        if (!article.findElements(HOME_PAGE_COMMENTS).isEmpty()) { //! menjaet znachenie na protivopolozhnoe
        WebElement homePageComments = article.findElement(HOME_PAGE_COMMENTS);

        //Save to Integer
        String commentsToParse = homePageComments.getText(); //(1)
        commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1);
        commentsToCompare = Integer.valueOf(commentsToParse);
        }
        //Open Article page
        homePageTitle.click();

        //Find article title
        String apTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        //Check title
        Assertions.assertEquals(titleToCompare, apTitle, "Wrong title on Article page");

        //Find comment count
        Integer apComments = Integer.valueOf(driver.findElement(ARTICLE_PAGE_COMMENTS).getText().substring(1, driver.findElement(ARTICLE_PAGE_COMMENTS).getText().length() - 1));

        // Check comment count
        Assertions.assertEquals(commentsToCompare, apComments, "Wrong comment count on Article page");

        //Open comments page
        driver.findElement(ARTICLE_PAGE_COMMENTS).click();

        //Find title
        String cpTitle = driver.findElement(COMMENT_PAGE_TITLE).getText();

        //Check title
        Assertions.assertEquals(titleToCompare, cpTitle, "Wrong title on comment page");

        //Get comment count


        //Check comment count
        //Close browser
    }
}
