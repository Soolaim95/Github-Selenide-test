package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GithubSearchPageObject {

    final private SelenideElement
            searchInput = $("[data-test-selector=nav-search-input]"),
            linkPage = $("ul.repo-list li").$("a"),
            title = $("h1"),
            searchWiki = $(".js-repo-nav #wiki-tab"),
            wikiFilter = $("#wiki-pages-filter"),
            searchElement = $$(".Box-row").findBy(visible),
            pageTitle = $("#repo-content-pjax-container h1"),
            searchCode = $(".markdown-body h4", 2);

    public GithubSearchPageObject searchSelenide() {
        searchInput.setValue("selenide").pressEnter();
        return this;
    }

    public GithubSearchPageObject openPage() {
        linkPage.click();
        return this;
    }

    public GithubSearchPageObject checkTitle() {
        title.shouldHave(text("selenide / selenide"));
        return this;
    }

    public GithubSearchPageObject wikiPage() {
    searchWiki.click();
    return this;
    }

    public GithubSearchPageObject searchSoft() {
        wikiFilter.setValue("SoftAssertions");
        return this;
    }

    public GithubSearchPageObject openSoft() {
        searchElement.click();
        return this;
    }

    public GithubSearchPageObject checkTitleSoft() {
        pageTitle.shouldHave(text("SoftAssertions"));
        return this;
    }

    public GithubSearchPageObject checkCode() {
        searchCode.shouldHave(text("Using JUnit5 extend test class:"));
        return this;
    }
}