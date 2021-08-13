package com.bestanswer.demonstracao.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String formatarData(LocalDateTime data) {
        return data.format(formatter);
    }
}
