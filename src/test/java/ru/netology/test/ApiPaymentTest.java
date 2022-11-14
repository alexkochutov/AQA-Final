package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.ApiHelper;
import ru.netology.data.DataHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.ApiHelper.getPaymentTour;

public class ApiPaymentTest {

    //
    //  Set of positive scenarios
    //

    @Test
    public void shouldReturnApprovedWithValidDataPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("APPROVED", getPaymentTour(request));
    }

    @Test
    public void shouldReturnDeclinedWithExpiredCardPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidDeclinedCardNumber(),
                DataHelper.getPreviousMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("DECLINED", getPaymentTour(request));
    }

    @Test
    public void shouldReturnDeclineWithValidDeclinedCardPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidDeclinedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("DECLINED", getPaymentTour(request));
    }

    //
    //  Set of negative scenarios for "Card Number" field
    //

    @Test
    public void shouldReturnErrorCardNumberIsEmptyPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getEmptyCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorCardNumberPresentedByOneDigitPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getCardNumberPresentedByOneDigit(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnDeclineUnknownCardNumberPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getUnknownCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnDeclineExtraLengthCardNumberPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getCardNumberWithExtraLength(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorCardNumberWithLatinSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getCardNumberWithLatinSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorCardNumberWithCyrillicSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getCardNumberWithCyrillicSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorCardNumberWithSpecialSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getCardNumberWithSpecialSymbol(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    //
    //  Set of negative scenarios for "Month" field
    //

    @Test
    public void shouldReturnErrorMonthIsEmptyPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getEmptyMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorMonthIsZeroPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getZeroMonth(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorMonthIsDoubleZeroPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getDoubleZeroMonth(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorMonthIsMoreThanExistPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthMoreThanExist(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorMonthConsistsOfOneDigitPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthConsistOfOneDigit(),
                DataHelper.getValidNextYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorMonthConsistsOfThreeDigitsPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthConsistOfThreeDigits(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorMonthWithLatinSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithLatinSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorMonthWithCyrillicSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithCyrillicSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorMonthWithSpecialSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getMonthWithSpecialSymbol(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getPaymentTour(request));
    }

    //
    //  Set of negative scenarios for "Year" field
    //

    @Test
    public void shouldReturnErrorYearIsEmptyPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getEmptyYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorYearIsZeroPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getZeroYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorYearIsDoubleZeroPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getDoubleZeroYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorYearIsMaxValuePayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearMaxValue(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorYearConsistsOfOneDigitPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearConsistOfOneDigit(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorYearConsistsOfThreeDigitsPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearConsistOfThreeDigits(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorYearWithLatinSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithLatinSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorYearWithCyrillicSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithCyrillicSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorYearWithSpecialSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getYearWithSpecialSymbol(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        assertEquals("400", getPaymentTour(request));
    }

    //
    //  Set of negative scenarios for "Name" field
    //

    @Test
    public void shouldReturnErrorNameIsEmptyPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getEmptyName(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithOneSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameConsistOfOneSymbol(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithLengthMoreThanAcceptedPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameLengthMoreThanAccepted(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithCyrillicSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithCyrillicSymbol(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithSpecialSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithSpecialSymbol(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithDigitsPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithDigits(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorNameWithoutLastnamePayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getNameWithoutLastname(),
                DataHelper.getValidCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    //
    //  Set of negative scenarios for "Code" field
    //

    @Test
    public void shouldReturnErrorWithEmptyCodePayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getEmptyCode()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorWithCodeConsistOfOneDigitPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithOneDigit()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorWithCodeConsistOfFourDigitsPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithFourDigit()
        );
        assertEquals("500", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorWithCodeWithLatinSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithLatinSymbol()
        );
        assertEquals("400", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorWithCodeWithCyrillicSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithCyrillicSymbol()
        );
        assertEquals("400", getPaymentTour(request));
    }

    @Test
    public void shouldReturnErrorWithCodeWithSpecialSymbolPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getValidApprovedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getCodeWithSpecialSymbol()
        );
        assertEquals("400", getPaymentTour(request));
    }

    //
    //  Negative scenario for All Empty fields
    //

    @Test
    public void shouldReturnErrorWithAllEmptyFieldsPayment() {
        ApiHelper.TourRequest request = new ApiHelper.TourRequest(
                DataHelper.getEmptyCardNumber(),
                DataHelper.getEmptyMonth(),
                DataHelper.getEmptyYear(),
                DataHelper.getEmptyName(),
                DataHelper.getEmptyCode()
        );
        assertEquals("500", getPaymentTour(request));
    }
}