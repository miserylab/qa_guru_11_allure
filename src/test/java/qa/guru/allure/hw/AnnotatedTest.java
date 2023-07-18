package qa.guru.allure.hw;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUENAME =  "issue_to_test_allure_report";
    @Test
    @Description("Шаги с аннотацией @Step")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithText(ISSUENAME);
    }
}
