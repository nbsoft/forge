package org.nbsoft.forge.sql.builders;

import org.nbsoft.forge.sql.Query;
import org.nbsoft.forge.sql.syntax.*;

import java.util.ArrayList;

public class SelectQueryBuilder implements SelectQuery {

    private String select;
    private String from;

    private ArrayList<String> conjunction = new ArrayList<>();
    private ArrayList<String> where = new ArrayList<>();
    private ArrayList<String> operator= new ArrayList<>();
    private ArrayList<Object> what = new ArrayList<>();

    @Override
    public From select(String select) {
        this.select = select;

        return this;
    }

    @Override
    public Where from(String from) {
        this.from = from;

        return this;
    }

    @Override
    public Operators where(String where) {
        this.conjunction.add("WHERE");
        this.where.add(where);

        return this;
    }

    @Override
    public Conjunctions equal(Object equal) {
        operator.add("=");
        what.add(equal);

        return this;
    }

    @Override
    public Conjunctions notEqual(Object notEqual) {
        operator.add("<>");
        what.add(notEqual);

        return this;
    }

    @Override
    public Conjunctions greaterThan(Object greaterThan) {
        operator.add(">");
        what.add(greaterThan);

        return this;
    }

    @Override
    public Conjunctions lessThan(Object lessThan) {
        operator.add("<");
        what.add(lessThan);

        return this;
    }

    @Override
    public Conjunctions greaterThanOrEqual(Object greaterThanOrEqual) {
        operator.add(">=");
        what.add(greaterThanOrEqual);

        return this;
    }

    @Override
    public Conjunctions lessThanOrEqual(Object greaterThanOrEqual) {
        operator.add("<=");
        what.add(greaterThanOrEqual);

        return this;
    }

    @Override
    public Conjunctions between(Object between) {
        operator.add("BETWEEN");
        what.add(between);

        return this;
    }

    @Override
    public Conjunctions like(Object like) {
        operator.add("LIKE");
        what.add(like);

        return this;
    }

    @Override
    public Conjunctions in(Object in) {
        operator.add("IN");
        what.add(in);

        return this;
    }

    @Override
    public Operators and(String and) {
        this.conjunction.add("AND");
        this.where.add(and);

        return this;
    }

    @Override
    public Operators or(String or) {
        this.conjunction.add("OR");
        this.where.add(or);

        return this;
    }

    @Override
    public Query build() {
        String query = "SELECT " + select + "\n";
        query += "FROM " + from;

        if (!conjunction.isEmpty()) {
            for (int i = 0; i < where.size(); i++) {
                query += "\n" + conjunction.get(i) + " " + where.get(i) + " " + operator.get(i) + " " + what.get(i);
            }
        }

        query += ";";

        return new Query(query);
    }

}
