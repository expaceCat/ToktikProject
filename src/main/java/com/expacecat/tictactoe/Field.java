package com.expacecat.tictactoe;

import java.util.Arrays;

public class Field {
    private final String[] storage = new String[9];

    public Field() {
        Arrays.fill(storage, "*");
    }

    public String getItemValue(int position) {
        return storage[position];
    }

    public void setItemValue(int position, String value) {
        this.storage[position] = value;
    }

}
