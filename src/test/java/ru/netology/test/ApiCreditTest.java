package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.ApiHelper;
import ru.netology.data.DataHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.ApiHelper.getCreditTour;

public class ApiCreditTest {

    //
    //  Set of positive scenarios
    //

    @Test
    public void shouldReturnApprovedWithValidDataCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("APPROVED", getCreditTour(request));
    }

    @Test
    public void shouldReturnDeclinedWithExpiredCardCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidDeclinedCardNumber(),
                DataHelper.getPreviousMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("DECLINED", getCreditTour(request));
    }

    @Test
    public void shouldReturnDeclineWithValidDeclinedCardCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidDeclinedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("DECLINED", getCreditTour(request));
    }

    //
    //  Set of negative scenarios for "Card Number" field
    //

    @Test
    public void shouldReturnErrorCardNumberIsEmptyCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getEmptyCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorCardNumberPresentedByOneDigitCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getCardNumberPresentedByOneDigit(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnDeclineUnknownCardNumberCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getUnknownCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnDeclineExtraLengthCardNumberCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getCardNumberWithExtraLength(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorCardNumberWithLatinSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getCardNumberWithLatinSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorCardNumberWithCyrillicSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getCardNumberWithCyrillicSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorCardNumberWithSpecialSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getCardNumberWithSpecialSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    //
    //  Set of negative scenarios for "Month" field
    //

    @Test
    public void shouldReturnErrorMonthIsEmptyCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getEmptyMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorMonthIsZeroCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getZeroMonth(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorMonthIsDoubleZeroCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getDoubleZeroMonth(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorMonthIsMoreThanExistCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthMoreThanExist(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorMonthConsistsOfOneDigitCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthConsistOfOneDigit(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorMonthConsistsOfThreeDigitsCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthConsistOfThreeDigits(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorMonthWithLatinSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithLatinSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorMonthWithCyrillicSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithCyrillicSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorMonthWithSpecialSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithSpecialSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getCreditTour(request));
    }

    //
    //  Set of negative scenarios for "Year" field
    //

    @Test
    public void shouldReturnErrorYearIsEmptyCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getEmptyYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorYearIsZeroCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getZeroYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorYearIsDoubleZeroCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getDoubleZeroYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorYearIsMaxValueCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearMaxValue(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorYearConsistsOfOneDigitCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearConsistOfOneDigit(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorYearConsistsOfThreeDigitsCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearConsistOfThreeDigits(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorYearWithLatinSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithLatinSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorYearWithCyrillicSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithCyrillicSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorYearWithSpecialSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithSpecialSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getCreditTour(request));
    }

    //
    //  Set of negative scenarios for "Name" field
    //

    @Test
    public void shouldReturnErrorNameIsEmptyCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getEmptyName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithOneSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameConsistOfOneSymbol(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithLengthMoreThanAcceptedCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameLengthMoreThanAccepted(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithCyrillicSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithCyrillicSymbol(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithSpecialSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithSpecialSymbol(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithDigitsCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithDigits(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithoutLastnameCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithoutLastname(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    //
    //  Set of negative scenarios for "Code" field
    //

    @Test
    public void shouldReturnErrorWithEmptyCodeCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getEmptyCode()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorWithCodeConsistOfOneDigitCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithOneDigit()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorWithCodeConsistOfFourDigitsCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithFourDigit()
        );
        assertEquals("500", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorWithCodeWithLatinSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithLatinSymbol()
        );
        assertEquals("400", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorWithCodeWithCyrillicSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithCyrillicSymbol()
        );
        assertEquals("400", getCreditTour(request));
    }

    @Test
    public void shouldReturnErrorWithCodeWithSpecialSymbolCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithSpecialSymbol()
        );
        assertEquals("400", getCreditTour(request));
    }

    //
    //  Negative scenario for All Empty fields
    //

    @Test
    public void shouldReturnErrorWithAllEmptyFieldsCredit() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getEmptyCardNumber(),
                DataHelper.getEmptyMonth(),
                DataHelper.getEmptyYear(),
                DataHelper.getEmptyName(),
                DataHelper.getEmptyCode()
        );
        assertEquals("500", getCreditTour(request));
    }
}
