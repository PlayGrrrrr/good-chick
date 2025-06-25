package com.gc.util;

import java.io.PrintStream;

public class ConsoleHelper {
    public static void enableUTF8Output() {
        try {
            System.setOut(new PrintStream(System.out, true, "GB18030"));
        } catch (Exception ignored) {}
    }
}
