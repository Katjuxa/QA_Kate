import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DelfiArticleTest {

    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[@class='comment-count text-red-ribbon']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-md-30')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'text-size-19')]");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[@class = 'article-title']/a");
    private final By ARTICLE = By.xpath(".//span[@class = 'text-size-22 d-block']");
    private final By COMMENT_PAGE_COMMENT = By.xpath(".//span [@class = 'type-cnt']");
    private static final Logger LOGGER = LogManager.getLogger(DelfiArticleTest.class);


    @Test
    public void titleAnsCommentsTest() {

        LOGGER.info("Open browser");
        //Open browser
        System.setProperty("webdriver.chrome.driver", "C:/QA2/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        LOGGER.info("Open Delfi Home");
        //Open Delfi Home page
        driver.get("http://rus.delfi.lv");

        //Find 1st Article
        WebElement article = driver.findElements(ARTICLE).get(0);

        //Find 1st article title
        WebElement homePageTitle = article.findElement(HOME_PAGE_TITLE);

        //Save to String
        String titleToCompare = homePageTitle.getText().trim();

        //Find comments count
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
        String apTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText().trim();

        //Check title
        Assertions.assertEquals(titleToCompare, apTitle, "Wrong title on Article page");

        //Find comment count
        Integer apComments = Integer.valueOf(driver.findElement(ARTICLE_PAGE_COMMENTS).getText().substring(1, driver.findElement(ARTICLE_PAGE_COMMENTS).getText().length() - 1));

        // Check comment count
        Assertions.assertEquals(commentsToCompare, apComments, "Wrong comment count on Article page");

        //Open comments page
        driver.findElement(ARTICLE_PAGE_COMMENTS).click();

        //Find title
        String cpTitle = driver.findElement(COMMENT_PAGE_TITLE).getText().trim();

        //Check title
        LOGGER.info("Check title on comment page");
        Assertions.assertEquals(titleToCompare, cpTitle, "Wrong title on comment page");

        //Get comment  count
        List<WebElement> cpComments = driver.findElements(COMMENT_PAGE_COMMENT);

//        String anonim  = driver.findElements(COMMENT_PAGE_COMMENT).get(0).getText();
//        String reg  = driver.findElements(COMMENT_PAGE_COMMENT).get(1).getText();

        String anonim = cpComments.get(0).getText();
        String anonim1 = anonim.substring(1, anonim.length() -1);
        Integer anon_com = Integer.valueOf(anonim1);
        String reg = cpComments.get(1).getText();
        String reg1 = reg.substring(1, reg.length() -1);
        Integer reg_com = Integer.valueOf(reg1);

        //Result of comment count on comment page
        Integer com_on_cp = anon_com + reg_com;

        //Check comment count
        Assertions.assertEquals(commentsToCompare, com_on_cp, "Wrong comment count on comment page");

        //Close browser
        driver.close();
        System.out.println(anonim1);


    }

//        String qwer = cpComments.get(0).g

//        WebElement ee = driver.findElements(COMMENT_PAGE_COMMENT).get(0);

        //        WebElement suka = cpComments.get(0);
//        String aaa = suka.getText()
//        for (int i = 0; i < cpComments.size(); i++) {
//            WebElement anonim = toString();
//        }



//        driver.close();
    }
//}
