package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.GithubSearchPageObject;

import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubTest {

    GithubSearchPageObject githubSearchPageObject = new GithubSearchPageObject();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1920x1080";
    }
    
    @BeforeEach
    static void beforeEach() {
        open("https://github.com/");
    }

    @Test
    void selenideSearchInGithub() {
        githubSearchPageObject
                //Открыть страницу Selenide в Github
                .searchSelenide()
                .openPage()
                .checkTitle()
                //Перейти в раздел Wiki
                .wikiPage()
                //Перейти в раздел SoftAssertions
                .searchSoft()
                .openSoft()
                .checkTitleSoft()
                //Найти пример кода для JUnit5
                .checkCode();
    }
}
