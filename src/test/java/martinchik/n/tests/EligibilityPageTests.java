package martinchik.n.tests;

import martinchik.n.helpers.DriverUtils;
import io.qameta.allure.Description;
import martinchik.n.pages.EligibilityCheckPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class EligibilityPageTests extends TestBase {
    @Test
    @Description("Check Rewards card eligibility")
    @DisplayName("Check Rewards card eligibility")
    void eligibilityTest() {
        step("Open Check your eligibility page", () -> {
            new EligibilityCheckPage().openPage();
            new EligibilityCheckPage().removeFooter();
        });

        step("Select Barclays rewards card", () -> {
            new EligibilityCheckPage().selectCard();
        });

        step("Click Check your eligibility", () -> {
            new EligibilityCheckPage().startCheck();
        });

        step("Switch to new tab", () -> {
            new EligibilityCheckPage().newTab();
        });

        step("Fill the form", () -> {
            new EligibilityCheckPage().notExistingCustomer();
            new EligibilityCheckPage().selectTitleMr();
            new EligibilityCheckPage().setName(firstName);
            new EligibilityCheckPage().setMiddleName(firstName);
            new EligibilityCheckPage().setLastName(lastName);
            new EligibilityCheckPage().selectGenderMale();
            new EligibilityCheckPage().setBirthDay(day);
            new EligibilityCheckPage().setBirthMonth(month);
            new EligibilityCheckPage().setBirthYear(year);
            new EligibilityCheckPage().selectNationality();
            new EligibilityCheckPage().setPhoneNumber(phone);
            new EligibilityCheckPage().setEmail(email);
            new EligibilityCheckPage().checkSmsContact();
            new EligibilityCheckPage().setHouseNumber(houseNumber);
            new EligibilityCheckPage().setPostcode(postcode);
            new EligibilityCheckPage().selectEmpStatusHomemaker();
            new EligibilityCheckPage().setMonthlyIncome(monthlyIncome);
            new EligibilityCheckPage().setAnnualIncome(annualIncome);
            new EligibilityCheckPage().checkAnnualIncomeDecreaseNo();
            new EligibilityCheckPage().selectZeroDependants();
            new EligibilityCheckPage().setZeroChildcareSpend();
            new EligibilityCheckPage().checkMonthlySpendIncreaseNo();
            new EligibilityCheckPage().checkIsBarclaysAccountNo();
            new EligibilityCheckPage().selectPreferredInternetBanking();
            new EligibilityCheckPage().selectEverydayPurchase();
            new EligibilityCheckPage().checkCashWithdrawalsYes();
            new EligibilityCheckPage().checkBalanceTransferYes();
            new EligibilityCheckPage().setBalanceTransferAmount(btAmount);
        });

        step("Input fields are successfully filled", () -> {
            $("#firstName").shouldHave(value(firstName));
            $("#middleName").shouldHave(value(firstName));
            $("#lastName").shouldHave(value(lastName));
            $("#dateOfBirthDay").shouldHave(value(String.valueOf(day)));
            $("#dateOfBirthMonth").shouldHave(value(String.valueOf(month)));
            $("#dateOfBirthYear").shouldHave(value(String.valueOf(year)));
            $("#emailHome").shouldHave(value(email));
            $("#currentSearch_HouseNumberOrName").shouldHave(value(String.valueOf(houseNumber)));
            $("#netMonthlyIncome").shouldHave(value(String.valueOf(monthlyIncome)));
            $("#currentAnnualIncome").shouldHave(value(String.valueOf(annualIncome)));
            $("#btAmount").shouldHave(value(String.valueOf(btAmount)));
        });
    }

    @Test
    @Description("Page title test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open Check your eligibility page", () ->
            new EligibilityCheckPage().openPage()
        );

        step("Page title should have text 'Credit card eligibility checker | Barclays'", () -> {
            String expectedTitle = "Credit card eligibility checker | Barclays";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Existing client error")
    @DisplayName("Existing client error")
    void existingClientError() {
        step("Open Eligibility form", () ->
                new EligibilityCheckPage().openForm()
        );

        step("User is existing customer checkbox", () -> {
                    new EligibilityCheckPage().isExistingCustomer();
        });

        step("Error text is displayed under the checkbox", () -> {
            $("#isExistingBarclaycardCustomer_error").shouldHave(text("If you already have a Barclaycard, you can use the Barclays or Barclaycard app to check if you're eligible to change to a different card. Log in to your app, open 'Cards' from the home page and select 'Change to a different card'"));
        });
    }

    @Test
    @Description("Title and gender mismatch error")
    @DisplayName("Title and gender mismatch error")
    void genderError() {
        step("Open Eligibility form", () -> {
            new EligibilityCheckPage().openForm();
            new EligibilityCheckPage().acceptCookies();
        });

        step("User is not existing customer", () -> {
            new EligibilityCheckPage().notExistingCustomer();
        });
        step("Select Mrs title", () -> {
            new EligibilityCheckPage().selectTitleMrs();
        });
        step("Select Male gender", () -> {
            new EligibilityCheckPage().selectGenderMale();
        });

        step("Error text is displayed under the checkbox", () -> {
            $("#genderError").shouldHave(text("Your gender does not match the title you provided. Please check and try again."));
        });
    }

    @Test
    @Description("Console log test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open Check your eligibility page", () ->
            new EligibilityCheckPage().openPage()
        );

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}