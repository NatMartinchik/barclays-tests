package martinchik.n.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class EligibilityCheckPage {


    //locators

    //actions
    public void openPage() {
        open("https://www.barclays.co.uk/credit-cards/check-your-eligibility/");
    }

    public void removeFooter() {
        zoom(0.5);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public void openForm() {
        open("https://apply-mobile.barclaycard/uka-client-index.html#customer-quote/pc=10127&mc=628YG6&sn=1");
    }

    public void acceptCookies() {
        $(byText("Accept All")).click();
        executeJavaScript("$('#inner_ribbon').remove()");
    }

    public void selectCard() {
        $("a[href*='/credit-cards/reward-cards/barclays-rewards/?'").click();
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public void startCheck() {
        $(byText("Accept All")).click();
        $(byText("Check your eligibility")).click();
    }

    public void newTab() {
        switchTo().window(1);
        $("h2").shouldBe(Condition.visible, Duration.ofSeconds(10));
        $("h2").shouldHave(text("Confirm your eligibility for this card"));
        $(byText("Accept All")).click();
        executeJavaScript("$('#inner_ribbon').remove()");
    }

    public void notExistingCustomer() {
        $("#isExistingBarclaycardCustomer > .bc-radio:nth-child(2) .c-radio-mark").click();
    }

    public void isExistingCustomer() {
        $("#isExistingBarclaycardCustomer > .bc-radio:nth-child(1) .c-radio-mark").click();
    }

    public void selectTitleMr() {
        $("#dk0-combobox").click();
        $("#dk0-MR").click();
    }

    public void selectTitleMrs() {
        $("#dk0-combobox").click();
        $("#dk0-MRS").click();
    }

    public void setName(String value) {
        $("#firstName").setValue(value);
    }

    public void setMiddleName(String value) {
        $("#middleName").setValue(value);
    }

    public void setLastName(String value) {
        $("#lastName").setValue(value);
    }

    public void selectGenderMale() {
        $("#genderM_label").click();
    }

    public void setBirthDay(Integer value) {
        $("#dateOfBirthDay").sendKeys(String.valueOf(value));
    }
    public void setBirthMonth(Integer value) {
        $("#dateOfBirthMonth").sendKeys(String.valueOf(value));
    }
    public void setBirthYear(Integer value) {
        $("#dateOfBirthYear").sendKeys(String.valueOf(value));
    }

    public void selectNationality() {
        $("#dk1-combobox").click();
        $("#dk1-GB").click();
    }

    public void setPhoneNumber(String value) {
        $("#preferredContactNo").click();
        $("#preferredContactNo").setValue(value);
    }

    public void setEmail(String value) {
        $("#emailHome").setValue(value);
    }

    public void checkSmsContact() {
        $("#mobileDNP_label").click();
    }

    public void setHouseNumber(Integer value) {
        $("#currentSearch_HouseNumberOrName").sendKeys(String.valueOf(value));
    }

    public void setPostcode(String value) {
        $("#currentSearch_Postcode").setValue(value);
    }

    public void selectEmpStatusHomemaker() {
        $("#dk4-combobox").click();
        $(By.xpath("//ul[@id='dk4-listbox']/li[@id='dk4-H[H]']")).click();
    }

    public void setMonthlyIncome(Integer value) {
        $("#netMonthlyIncome").sendKeys(String.valueOf(value));
    }

    public void setAnnualIncome(Integer value) {
        $("#currentAnnualIncome").sendKeys(String.valueOf(value));
    }

    public void checkAnnualIncomeDecreaseNo() {
        $("#futureAnnualIncomeInd > .bc-radio:nth-child(2) .c-radio-mark").click();
    }

    public void selectZeroDependants() {
        $("#dk6-combobox").click();
        $("#dk6-0").click();
        $("#monthlyExpenditureDetails .form-row:nth-child(1)").click();
    }

    public void setZeroChildcareSpend() {
        $("#monthlyChildAndOtherCareAmount").click();
        $("#monthlyChildAndOtherCareAmount").setValue("0");
    }

    public void checkMonthlySpendIncreaseNo() {
        $("#monthlyFutureSpendInd > .bc-radio:nth-child(2) .c-radio-mark").click();
    }

    public void checkIsBarclaysAccountNo() {
        $("#isBarclaysAccount > .bc-radio:nth-child(2) .c-radio-mark").click();
    }

    public void selectPreferredInternetBanking() {
        $("#dk7-combobox").click();
        $("#dk7-I").click();
    }

    public void selectEverydayPurchase() {
        $("#dk8-combobox").click();
        $("#dk8-EP").click();
    }

    public void checkCashWithdrawalsYes() {
        $("#cashWithdrawalInd > .bc-radio:nth-child(1) > .radio-inline").click();
    }

    public void checkBalanceTransferYes() {
        $("#btRequired > .bc-radio:nth-child(1) .c-radio-mark").click();

    }

    public void setBalanceTransferAmount(Integer value) {
        $("#btAmount").click();
        $("#btAmount").sendKeys(String.valueOf(value));
    }
}