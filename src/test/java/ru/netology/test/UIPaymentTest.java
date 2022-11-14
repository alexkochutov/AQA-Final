package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.TourPage;

import static com.codeborne.selenide.Selenide.open;

public class UIPaymentTest {

    //
    //  Set of positive scenarios
    //

    @Test
    public void shouldReturnSuccessWithValidDataPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isSuccessful();
    }

    @Test
    public void shouldReturnDeclineWithExpiredCardPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getPreviousMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnDeclineWithValidDeclinedCardPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidDeclinedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isDeclined();
    }

    //
    //  Set of negative scenarios for "Card Number" field
    //

    @Test
    public void shouldReturnErrorCardNumberIsEmptyPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getEmptyCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardNumberInvalid();
    }

    @Test
    public void shouldReturnErrorCardNumberPresentedByOneDigitPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getCardNumberPresentedByOneDigit(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardNumberInvalid();
    }

    @Test
    public void shouldReturnDeclineUnknownCardNumberPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getUnknownCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isDeclined();
    }

    @Test
    public void shouldReturnDeclineExtraLengthCardNumberPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getCardNumberWithExtraLength(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isDeclined();
    }

    @Test
    public void shouldReturnErrorCardNumberWithLatinSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getCardNumberWithLatinSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardNumberInvalid();
    }

    @Test
    public void shouldReturnErrorCardNumberWithCyrillicSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getCardNumberWithCyrillicSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardNumberInvalid();
    }

    @Test
    public void shouldReturnErrorCardNumberWithSpecialSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getCardNumberWithSpecialSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardNumberInvalid();
    }

    //
    //  Set of negative scenarios for "Month" field
    //

    @Test
    public void shouldReturnErrorMonthIsEmptyPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getEmptyMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthIsZeroPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getZeroMonth(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthIsDoubleZeroPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getDoubleZeroMonth(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthIsMoreThanExistPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthMoreThanExist(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthConsistsOfOneDigitPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthConsistOfOneDigit(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthConsistsOfThreeDigitsPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthConsistOfThreeDigits(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthWithLatinSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithLatinSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthWithCyrillicSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithCyrillicSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthWithSpecialSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithSpecialSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isMonthInvalid();
    }

    //
    //  Set of negative scenarios for "Year" field
    //

    @Test
    public void shouldReturnErrorYearIsEmptyPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getEmptyYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearIsZeroPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getZeroYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearIsDoubleZeroPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getDoubleZeroYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearIsMaxValuePayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearMaxValue(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearConsistsOfOneDigitPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearConsistOfOneDigit(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearConsistsOfThreeDigitsPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearConsistOfThreeDigits(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearWithLatinSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithLatinSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearWithCyrillicSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithCyrillicSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearWithSpecialSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithSpecialSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isYearInvalid();
    }

    //
    //  Set of negative scenarios for "Name" field
    //

    @Test
    public void shouldReturnErrorNameIsEmptyPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getEmptyName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithOneSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameConsistOfOneSymbol(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithLengthMoreThanAcceptedPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameLengthMoreThanAccepted(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithCyrillicSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithCyrillicSymbol(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithSpecialSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithSpecialSymbol(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithDigitsPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithDigits(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithoutLastnamePayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithoutLastname(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardHolderInvalid();
    }

    //
    //  Set of negative scenarios for "Code" field
    //

    @Test
    public void shouldReturnErrorWithEmptyCodePayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getEmptyCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCodeInvalid();
    }

    @Test
    public void shouldReturnErrorWithCodeConsistOfOneDigitPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithOneDigit()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCodeInvalid();
    }

    @Test
    public void shouldReturnErrorWithCodeConsistOfFourDigitsPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithFourDigit()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCodeInvalid();
    }

    @Test
    public void shouldReturnErrorWithCodeWithLatinSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithLatinSymbol()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCodeInvalid();
    }

    @Test
    public void shouldReturnErrorWithCodeWithCyrillicSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithCyrillicSymbol()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCodeInvalid();
    }

    @Test
    public void shouldReturnErrorWithCodeWithSpecialSymbolPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithSpecialSymbol()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCodeInvalid();
    }

    //
    //  Negative scenario for All Empty fields
    //

    @Test
    public void shouldReturnErrorWithAllEmptyFieldsPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getEmptyCardNumber(),
                DataHelper.getEmptyMonth(),
                DataHelper.getEmptyYear(),
                DataHelper.getEmptyName(),
                DataHelper.getEmptyCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isCardNumberInvalid();
        page.isMonthInvalid();
        page.isYearInvalid();
        page.isCardHolderInvalid();
        page.isCodeInvalid();
    }
}