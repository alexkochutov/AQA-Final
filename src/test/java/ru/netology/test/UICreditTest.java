package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.TourPage;

import static com.codeborne.selenide.Selenide.open;
public class UICreditTest {

    //
    //  Set of positive scenarios
    //

    @Test
    public void shouldReturnSuccessWithValidDataCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isSuccessful();
    }

    @Test
    public void shouldReturnDeclineWithExpiredCardCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getPreviousMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnDeclineWithValidDeclinedCardCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidDeclinedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isDeclined();
    }

    //
    //  Set of negative scenarios for "Card Number" field
    //

    @Test
    public void shouldReturnErrorCardNumberIsEmptyCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getEmptyCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardNumberInvalid();
    }

    @Test
    public void shouldReturnErrorCardNumberPresentedByOneDigitCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getCardNumberPresentedByOneDigit(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardNumberInvalid();
    }

    @Test
    public void shouldReturnDeclineUnknownCardNumberCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getUnknownCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isDeclined();
    }

    @Test
    public void shouldReturnDeclineExtraLengthCardNumberCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getCardNumberWithExtraLength(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isDeclined();
    }

    @Test
    public void shouldReturnErrorCardNumberWithLatinSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getCardNumberWithLatinSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardNumberInvalid();
    }

    @Test
    public void shouldReturnErrorCardNumberWithCyrillicSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getCardNumberWithCyrillicSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardNumberInvalid();
    }

    @Test
    public void shouldReturnErrorCardNumberWithSpecialSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getCardNumberWithSpecialSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardNumberInvalid();
    }

    //
    //  Set of negative scenarios for "Month" field
    //

    @Test
    public void shouldReturnErrorMonthIsEmptyCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getEmptyMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthIsZeroCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getZeroMonth(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthIsDoubleZeroCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getDoubleZeroMonth(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthIsMoreThanExistCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthMoreThanExist(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthConsistsOfOneDigitCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthConsistOfOneDigit(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthConsistsOfThreeDigitsCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthConsistOfThreeDigits(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthWithLatinSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithLatinSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthWithCyrillicSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithCyrillicSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isMonthInvalid();
    }

    @Test
    public void shouldReturnErrorMonthWithSpecialSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithSpecialSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isMonthInvalid();
    }

    //
    //  Set of negative scenarios for "Year" field
    //

    @Test
    public void shouldReturnErrorYearIsEmptyCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getEmptyYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearIsZeroCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getZeroYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearIsDoubleZeroCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getDoubleZeroYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearIsMaxValueCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearMaxValue(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearConsistsOfOneDigitCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearConsistOfOneDigit(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearConsistsOfThreeDigitsCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearConsistOfThreeDigits(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearWithLatinSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithLatinSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearWithCyrillicSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithCyrillicSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isYearInvalid();
    }

    @Test
    public void shouldReturnErrorYearWithSpecialSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithSpecialSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isYearInvalid();
    }

    //
    //  Set of negative scenarios for "Name" field
    //

    @Test
    public void shouldReturnErrorNameIsEmptyCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getEmptyName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithOneSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameConsistOfOneSymbol(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithLengthMoreThanAcceptedCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameLengthMoreThanAccepted(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithCyrillicSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithCyrillicSymbol(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithSpecialSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithSpecialSymbol(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithDigitsCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithDigits(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardHolderInvalid();
    }

    @Test
    public void shouldReturnErrorNameWithoutLastnameCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithoutLastname(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardHolderInvalid();
    }

    //
    //  Set of negative scenarios for "Code" field
    //

    @Test
    public void shouldReturnErrorWithEmptyCodeCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getEmptyCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCodeInvalid();
    }

    @Test
    public void shouldReturnErrorWithCodeConsistOfOneDigitCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithOneDigit()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCodeInvalid();
    }

    @Test
    public void shouldReturnErrorWithCodeConsistOfFourDigitsCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithFourDigit()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isSuccessful();
    }

    @Test
    public void shouldReturnErrorWithCodeWithLatinSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithLatinSymbol()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCodeInvalid();
    }

    @Test
    public void shouldReturnErrorWithCodeWithCyrillicSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithCyrillicSymbol()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCodeInvalid();
    }

    @Test
    public void shouldReturnErrorWithCodeWithSpecialSymbolCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithSpecialSymbol()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCodeInvalid();
    }

    //
    //  Negative scenario for All Empty fields
    //

    @Test
    public void shouldReturnErrorWithAllEmptyFieldsCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getEmptyCardNumber(),
                DataHelper.getEmptyMonth(),
                DataHelper.getEmptyYear(),
                DataHelper.getEmptyName(),
                DataHelper.getEmptyCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isCardNumberInvalid();
        page.isMonthInvalid();
        page.isYearInvalid();
        page.isCardHolderInvalid();
        page.isCodeInvalid();
    }
}