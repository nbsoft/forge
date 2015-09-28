package org.nbsoft.forge.sql.builders.helpers;

public class Condition {

    private String conjunction;
    private String where;
    private String operator;
    private Object what;
    private Bracket bracket = Bracket.NONE;

    public String getConjunction() {
        return conjunction;
    }

    public void setConjunction(String conjunction) {
        this.conjunction = conjunction;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Object getWhat() {
        return what;
    }

    public void setWhat(Object what) {
        this.what = what;
    }

    public Bracket getBracket() {
        return bracket;
    }

    public void setBracket(Bracket bracket) {
        this.bracket = bracket;
    }

}
