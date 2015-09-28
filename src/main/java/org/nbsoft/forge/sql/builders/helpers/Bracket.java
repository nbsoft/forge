package org.nbsoft.forge.sql.builders.helpers;

public enum Bracket {

    OPEN("("),
    CLOSE(")"),
    NONE("");

    private String value;

    Bracket(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
