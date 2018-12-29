package com.chris.demo.java9;


/**
 * java 7     java 8       java 9
 * <p>
 * 常量       常量         常量
 * 抽象方法   抽象方法     抽象方法
 * 默认方法     默认方法
 * 静态方法     静态方法
 * 私有方法
 * 私有静态方法
 */

public interface PrivateInterface {

    String ORACLE = "Oracle_Database";
    String MYSQL = "MySql_Database";

    private void log(String message, String prefix) {
        getConnection();
        System.out.println("Log Message : " + prefix);
        closeConnection();
    }

    default void logInfo(String message) {
        log(message, "INFO");
    }

    default void logError(String message) {
        log(message, "ERROR");
    }

    private static void getConnection() {
        System.out.println("Open Database connection");
    }

    private static void closeConnection() {
        System.out.println("Close Database connection");
    }

}
