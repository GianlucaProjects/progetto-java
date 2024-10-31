package org.example;

public class Card {
    private String code;
    private boolean active;
    private int pin;

    public Card(String code, boolean active, int pin) {
        this.code = code;
        this.active = active;
        this.pin = pin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
