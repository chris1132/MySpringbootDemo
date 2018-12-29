package com.chris.demo.java9;


/**
 * java 7     java 8       java 9
 * <p>
 * ����       ����         ����
 * ���󷽷�   ���󷽷�     ���󷽷�
 * Ĭ�Ϸ���     Ĭ�Ϸ���
 * ��̬����     ��̬����
 * ˽�з���
 * ˽�о�̬����
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
