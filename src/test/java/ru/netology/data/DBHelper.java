package ru.netology.data;

import java.sql.*;

public class DBHelper {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/app";
    private static final String DB_USER = "app";
    private static final String DB_PASS = "123qwe!@#";

    public static String getLastPaymentId() {
        String QUERY_ID = "SELECT payment_id FROM order_entity ORDER BY created DESC LIMIT 1";
        String result = null;
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY_ID);) {
            while (rs.next()) {
                result = rs.getString("payment_id");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public static String getPaymentStatus() {
        String QUERY_PAYMENT_STATUS = "SELECT status FROM payment_entity WHERE transaction_id = '" + getLastPaymentId() + "'";
        String result = null;
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY_PAYMENT_STATUS);) {
            while (rs.next()) {
                result = rs.getString("status");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public static String getCreditStatus() {
        String QUERY_CREDIT_STATUS = "SELECT status FROM credit_request_entity WHERE bank_id = '" + getLastPaymentId() + "'";
        String result = null;
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY_CREDIT_STATUS);) {
            while (rs.next()) {
                result = rs.getString("status");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }
}