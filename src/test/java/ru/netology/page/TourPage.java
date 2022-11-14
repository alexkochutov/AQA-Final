package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class TourPage {
    private final SelenideElement paymentButton = $(byText("Купить"));
    private final SelenideElement creditButton = $(byText("Купить в кредит"));
    private final SelenideElement paymentHeader = $(byText("Оплата по карте"));
    private final SelenideElement creditHeader = $(byText("Кредит по данным карты"));
    private final SelenideElement orderForm = $("form.form");

    private final SelenideElement cardNumber = orderForm.$(byText("Номер карты")).parent().$(".input__control");
    private final SelenideElement cardMonth = orderForm.$(byText("Месяц")).parent().$(".input__control");
    private final SelenideElement cardYear = orderForm.$(byText("Год")).parent().$(".input__control");
    private final SelenideElement cardHolder = orderForm.$(byText("Владелец")).parent().$(".input__control");
    private final SelenideElement cardCode = orderForm.$(byText("CVC/CVV")).parent().$(".input__control");
    private final SelenideElement orderButton = orderForm.$("button");

    private final SelenideElement cardNumberError = orderForm.$(byText("Номер карты")).parent().$(".input__sub");
    private final SelenideElement cardMonthError = orderForm.$(byText("Месяц")).parent().$(".input__sub");
    private final SelenideElement cardYearError = orderForm.$(byText("Год")).parent().$(".input__sub");
    private final SelenideElement cardHolderError = orderForm.$(byText("Владелец")).parent().$(".input__sub");
    private final SelenideElement cardCodeError = orderForm.$(byText("CVC/CVV")).parent().$(".input__sub");

    private final SelenideElement successMessage = $(".notification_status_ok");
    private final SelenideElement successMessageTitle = successMessage.$("notification__title");
    private final SelenideElement successMessageContent = successMessage.$("notification__content");

    private final SelenideElement declineMessage = $(".notification_status_error");
    private final SelenideElement declineMessageTitle = declineMessage.$("notification__title");
    private final SelenideElement declineMessageContent = declineMessage.$("notification__content");

    public void fillForm(DataHelper.CardInfo cardInfo) {
        cardNumber.setValue(cardInfo.getCardNumber());
        cardMonth.setValue(cardInfo.getCardMonth());
        cardYear.setValue(cardInfo.getCardYear());
        cardHolder.setValue(cardInfo.getCardHolder());
        cardCode.setValue(cardInfo.getCardCode());
    }

    public void sendOrder() {
        orderButton.click();
    }

    public void getPayment(DataHelper.CardInfo cardInfo) {
        paymentButton.click();
        paymentHeader.shouldBe(Condition.visible);
        orderForm.shouldBe(Condition.visible);
        fillForm(cardInfo);
        sendOrder();
    }

    public void getCredit(DataHelper.CardInfo cardInfo) {
        creditButton.click();
        creditHeader.shouldBe(Condition.visible);
        orderForm.shouldBe(Condition.visible);
        fillForm(cardInfo);
        sendOrder();
    }

    public void isSuccessful() {
        successMessage.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void isDeclined() {
        declineMessage.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void isCardNumberInvalid() {
        cardNumberError.shouldBe(Condition.visible);
    }

    public void isMonthInvalid() {
        cardMonthError.shouldBe(Condition.visible);
    }

    public void isYearInvalid() {
        cardYearError.shouldBe(Condition.visible);
    }

    public void isCardHolderInvalid() {
        cardHolderError.shouldBe(Condition.visible);
    }

    public void isCodeInvalid() {
        cardCodeError.shouldBe(Condition.visible);
    }
}