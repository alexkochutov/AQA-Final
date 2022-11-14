package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    private DataHelper() {}

    public static class CardInfo {
        private String cardNumber;
        private String cardMonth;
        private String cardYear;
        private String cardHolder;
        private String cardCode;

        private CardInfo() {}

        public CardInfo(String cardNumber, String cardMonth, String cardYear, String cardHolder, String cardCode) {
            this.cardNumber = cardNumber;
            this.cardMonth = cardMonth;
            this.cardYear = cardYear;
            this.cardHolder = cardHolder;
            this.cardCode = cardCode;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public String getCardMonth() {
            return cardMonth;
        }

        public String getCardYear() {
            return cardYear;
        }

        public String getCardHolder() {
            return cardHolder;
        }

        public String getCardCode() {
            return cardCode;
        }
    }

    //
    //  Methods for generating card's number
    //

    public static String getValidApprovedCardNumber() {
        return "1111 2222 3333 4444";
    }

    public static String getValidDeclinedCardNumber() {
        return "5555 6666 7777 8888";
    }

    public static String getUnknownCardNumber() {
        return "1111 5555 2222 7777";
    }

    public static String getEmptyCardNumber() {
        return "";
    }

    public static String getCardNumberPresentedByOneDigit() {
        return "1";
    }

    public static String getCardNumberWithExtraLength() {
        return "1111 5555 2222 7777 8";
    }

    public static String getCardNumberWithLatinSymbol() {
        return "1111 F555 2222 7777";
    }

    public static String getCardNumberWithCyrillicSymbol() {
        return "1111 Ф555 2222 7777";
    }

    public static String getCardNumberWithSpecialSymbol() {
        return "1111 $555 2222 7777";
    }

    //
    //  Methods for generating month's number
    //

    public static String getValidMonth() {
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");
        return LocalDate.now().format(monthFormatter);
    }

    public static String getPreviousMonth() {
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");
        return LocalDate.now().minusMonths(1).format(monthFormatter);
    }

    public static String getEmptyMonth() {
        return "";
    }

    public static String getZeroMonth() {
        return "0";
    }

    public static String getDoubleZeroMonth() {
        return "00";
    }

    public static String getMonthMoreThanExist() {
        return "13";
    }

    public static String getMonthConsistOfOneDigit() {
        return "1";
    }

    public static String getMonthConsistOfThreeDigits() {
        return "321";
    }

    public static String getMonthWithLatinSymbol() {
        return "F2";
    }

    public static String getMonthWithCyrillicSymbol() {
        return "Ф2";
    }

    public static String getMonthWithSpecialSymbol() {
        return "$2";
    }

    //
    //  Methods for generating year's number
    //

    public static String getValidYear() {
        DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yy");
        return LocalDate.now().format(yearFormatter);
    }

    public static String getValidNextYear() {
        DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yy");
        return LocalDate.now().plusYears(1).format(yearFormatter);
    }

    public static String getEmptyYear() {
        return "";
    }

    public static String getZeroYear() {
        return "0";
    }

    public static String getDoubleZeroYear() {
        return "00";
    }

    public static String getYearMaxValue() {
        return "99";
    }

    public static String getYearConsistOfOneDigit() {
        return "2";
    }

    public static String getYearConsistOfThreeDigits() {
        return "321";
    }

    public static String getYearWithLatinSymbol() {
        return "F2";
    }

    public static String getYearWithCyrillicSymbol() {
        return "Ф2";
    }

    public static String getYearWithSpecialSymbol() {
        return "$2";
    }

    //
    //  Methods for generating name
    //

    public static String getValidName() {
        Faker faker = new Faker(new Locale("en-EN"));
        return faker.name().fullName();
    }

    public static String getEmptyName() {
        return "";
    }

    public static String getNameConsistOfOneSymbol() {
        return "A";
    }

    public static String getNameLengthMoreThanAccepted() {
        return "Hubert Blaine Wolfeschlegeln";
    }

    public static String getNameWithCyrillicSymbol() {
        return "Hubert Бlaine";
    }

    public static String getNameWithSpecialSymbol() {
        return "Hubert Bl@ine";
    }

    public static String getNameWithDigits() {
        return "Hubert Bl2ine";
    }

    public static String getNameWithoutLastname() {
        return "Hubert";
    }

    //
    //  Methods for generating card's security code
    //

    public static String getValidCode() {
        return "123";
    }

    public static String getEmptyCode() {
        return "";
    }

    public static String getCodeWithOneDigit() {
        return "1";
    }

    public static String getCodeWithFourDigit() {
        return "1234";
    }

    public static String getCodeWithLatinSymbol() {
        return "12A";
    }

    public static String getCodeWithCyrillicSymbol() {
        return "12Ф";
    }

    public static String getCodeWithSpecialSymbol() {
        return "12$";
    }
}