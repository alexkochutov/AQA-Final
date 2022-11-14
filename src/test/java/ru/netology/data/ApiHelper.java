package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiHelper {
    private static final RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    private ApiHelper() {};

    private static String sendPaymentRequest(TourRequest request) {
        var response = given()
                .spec(spec)
                .body(request)
        .when()
                .post("api/v1/pay");
        if (response.statusCode() == 200) {
            return response.path("status").toString();
        } else {
            return "" + response.statusCode();
        }
    }

    private static String sendCreditRequest(TourRequest request) {
        var response = given()
                .spec(spec)
                .body(request)
        .when()
                .post("api/v1/credit");
        if (response.statusCode() == 200) {
            return response.path("status").toString();
        } else {
            return "" + response.statusCode();
        }
    }

    public static String getPaymentTour(TourRequest request) {
        return sendPaymentRequest(request);
    }

    public static String getCreditTour(TourRequest request) {
        return sendCreditRequest(request);
    }

    public static class TourRequest {
        String number;
        String month;
        String year;
        String holder;
        String cvc;

        private TourRequest () {};

        public TourRequest(String number, String month, String year, String holder, String cvc) {
            this.number = number;
            this.month = month;
            this.year = year;
            this.holder = holder;
            this.cvc = cvc;
        }

        public String getCardNumber() {
            return number;
        }

        public String getMonth() {
            return month;
        }

        public String getYear() {
            return year;
        }

        public String getName() {
            return holder;
        }

        public String getCvv() {
            return cvc;
        }
    }
}