package com.bignerdranch.androidboy.calculator;

/**
 * Created by androidboy on 17-12-27.
 */

public class Numbers {
    private double number;
    private boolean multiply;
    private boolean munis;
    private boolean divide;

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public boolean isMultiply() {
        return multiply;
    }

    public void setMultiply(boolean multiply) {
        this.multiply = multiply;
    }

    public boolean isMunis() {
        return munis;
    }

    public void setMunis(boolean munis) {
        this.munis = munis;
    }

    public boolean isDivide() {
        return divide;
    }

    public void setDivide(boolean divide) {
        this.divide = divide;
    }
}
