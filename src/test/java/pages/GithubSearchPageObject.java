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
            title = $("h2"),
            searchWiki = $(".js-repo-nav #wiki-tab"),
            wikiFilter = $("#wiki-pages-filter"),
            searchElement = $$(".Box-row").findBy(visible),
            pageTitle = $("#repo-content-pjax-container h1"),
            searchCode = $(".markdown-body h4", 2);

    public GithubSearchPageObject searchSelenide(String selenide) {
        searchInput.setValue(selenide).pressEnter();
        return this;
    }

    public GithubSearchPageObject openPage() {
        linkPage.click();
        return this;
    }

    public GithubSearchPageObject checkTitle(String titleValue) {
        title.shouldHave(text(titleValue));
        return this;
    }

    public GithubSearchPageObject wikiPage() {
    searchWiki.click();
    return this;
    }

    public GithubSearchPageObject searchSoft(String softAssertions) {
        wikiFilter.setValue(softAssertions);
        return this;
    }

    public GithubSearchPageObject openSoft() {
        searchElement.click();
        return this;
    }

    public GithubSearchPageObject checkTitleSoft(String softAssertions) {
        pageTitle.shouldHave(text(softAssertions));
        return this;
    }

    public GithubSearchPageObject checkCode(String checkText) {
        searchCode.shouldHave(text(checkText));
        return this;
    }
}