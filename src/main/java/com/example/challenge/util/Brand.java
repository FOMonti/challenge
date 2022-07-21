package com.example.challenge.util;

import java.time.LocalDate;

public enum Brand {

    VISA(0),
    NARA(1),
    AMEX(2);

    private final int tipoOperation;

    Brand(int tipoOperation) {
        this.tipoOperation = tipoOperation;
    }

    public double tasa(LocalDate date) {
        switch (tipoOperation) {
            case 0:
                return Math.floorDiv((date.getYear() - 2000), date.getMonthValue());
            case 1:
                return date.getDayOfMonth() * 0.5;
            case 2:
                return date.getMonthValue() * 0.1;
        }
        return 0;
    }
}
