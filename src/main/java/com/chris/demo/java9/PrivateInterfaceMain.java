package com.chris.demo.java9;

public class PrivateInterfaceMain {
    public static void main(String[] args) {
        LogOracle log = new LogOracle();
        log.logInfo("");
        log.logError("");

        LogMySql log1 = new LogMySql();
        log1.logInfo("");
        log1.logError("");
    }
}

final class LogOracle implements PrivateInterface {
}

final class LogMySql implements PrivateInterface {
}