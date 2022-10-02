package martinchik.n.tests;

import com.github.javafaker.Faker;
import martinchik.n.config.Project;
import martinchik.n.helpers.AllureAttachments;
import martinchik.n.helpers.DriverSettings;
import martinchik.n.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Locale;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    Faker faker = new Faker();
    Faker ukFaker = new Faker(new Locale("en-GB"));

    String  firstName = ukFaker.name().firstName(),
            lastName = ukFaker.name().lastName(),
            email = ukFaker.internet().emailAddress(),
            postcode = ukFaker.address().zipCode(),
            phone = ukFaker.phoneNumber().cellPhone();

    Integer day = ukFaker.number().numberBetween(0,28),
            month = ukFaker.number().numberBetween(0,12),
            year = ukFaker.number().numberBetween(1950,2002),
            houseNumber = ukFaker.number().numberBetween(0,50),
            monthlyIncome = ukFaker.number().numberBetween(2000,5000),
            annualIncome = ukFaker.number().numberBetween(30000,70000),
            btAmount = ukFaker.number().numberBetween(3000,7000);

    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
