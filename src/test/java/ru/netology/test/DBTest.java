package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.TourPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DBHelper.getCreditStatus;
import static ru.netology.data.DBHelper.getPaymentStatus;

public class DBTest {

    @Test
    public void shouldReturnSuccessWithApprovedCardPayment() {
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
        String expected = "APPROVED";
        String actual = getPaymentStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDeclineWithDeclinedCardPayment() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidDeclinedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getPayment(cardInfo);
        page.isSuccessful();
        String expected = "DECLINED";
        String actual = getPaymentStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSuccessWithApprovedCardCredit() {
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
        String expected = "APPROVED";
        String actual = getCreditStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDeclineWithDeclinedCardCredit() {
        DataHelper.CardInfo cardInfo = new DataHelper.CardInfo(
                DataHelper.getValidDeclinedCardNumber(),
                DataHelper.getValidMonth(),
                DataHelper.getValidYear(),
                DataHelper.getValidName(),
                DataHelper.getValidCode()
        );
        TourPage page = open("http://localhost:8080", TourPage.class);
        page.getCredit(cardInfo);
        page.isSuccessful();
        String expected = "DECLINED";
        String actual = getCreditStatus();
        assertEquals(expected, actual);
    }
}