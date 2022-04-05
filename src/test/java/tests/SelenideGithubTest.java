package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.GithubSearchPageObject;

import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {

    GithubSearchPageObject githubSearchPageObject = new GithubSearchPageObject();
    String titleValue = "selenide / selenide",
           selenide = "selenide",
           softAssertions = "SoftAssertions",
           checkText = "Using JUnit5 extend test class:";



    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1920x1080";
    }
    
    @BeforeEach
    void beforeEach() {
        open("https://github.com/");
    }

    @Test
    void selenideSearchInGithub() {
        githubSearchPageObject
                //Открыть страницу Selenide в Github
                .searchSelenide(selenide)
                .openPage()
                .checkTitle(titleValue)
                //Перейти в раздел Wiki
                .wikiPage()
                //Перейти в раздел SoftAssertions
                .searchSoft(softAssertions)
                .openSoft()
                .checkTitleSoft(softAssertions)
                //Найти пример кода для JUnit5
                .checkCode(checkText);
    }
}
