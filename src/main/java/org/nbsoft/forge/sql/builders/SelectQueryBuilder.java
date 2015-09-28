/*
 * Copyright (C) 2015 NB Soft (info@nbsoft.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nbsoft.forge.sql.builders;

import org.nbsoft.forge.sql.Query;
import org.nbsoft.forge.sql.builders.helpers.Bracket;
import org.nbsoft.forge.sql.builders.helpers.Condition;
import org.nbsoft.forge.sql.syntax.*;
import org.nbsoft.forge.sql.syntax.conjunctions.Where;
import org.nbsoft.forge.sql.syntax.statements.SelectStatement;

import java.util.ArrayList;
import java.util.List;

public class SelectQueryBuilder implements SelectStatement, Builder<Query> {

    private String select;
    private String from;

    private Condition condition = new Condition();
    private List<Condition> conditionList = new ArrayList<>();

    private String orderBy;
    private String order;

    /* Command */

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

    /* Conjunctions */

    @Override
    public Operator where(String where) {
        return where(condition.getBracket(), where);
    }

    @Override
    public Operator where(Bracket bracket, String where) {
        initConjunction("WHERE", where, bracket);

        return this;
    }

    @Override
    public Operator and(String and) {
        return and(condition.getBracket(), and);
    }

    @Override
    public Operator and(Bracket bracket, String and) {
        initConjunction("AND", and, bracket);

        return this;
    }

    @Override
    public Operator or(String or) {
        return or(condition.getBracket(), or);
    }

    @Override
    public Operator or(Bracket bracket, String or) {
        initConjunction("OR", or, bracket);

        return this;
    }

    /* Operators */

    @Override
    public Conjunction equal(Object equal) {
        return equal(equal, condition.getBracket());
    }

    @Override
    public Conjunction equal(Object equal, Bracket bracket) {
        initOperator("=", equal, bracket);

        return this;
    }

    @Override
    public Conjunction notEqual(Object notEqual) {
        return notEqual(notEqual, condition.getBracket());
    }

    @Override
    public Conjunction notEqual(Object notEqual, Bracket bracket) {
        initOperator("<>", notEqual, bracket);

        return this;
    }

    @Override
    public Conjunction greaterThan(Object greaterThan) {
        return greaterThan(greaterThan, condition.getBracket());
    }

    @Override
    public Conjunction greaterThan(Object greaterThan, Bracket bracket) {
        initOperator(">", greaterThan, bracket);

        return this;
    }

    @Override
    public Conjunction lessThan(Object lessThan) {
        return lessThan(lessThan, condition.getBracket());
    }

    @Override
    public Conjunction lessThan(Object lessThan, Bracket bracket) {
        initOperator("<", lessThan, bracket);

        return this;
    }

    @Override
    public Conjunction greaterThanOrEqual(Object greaterThanOrEqual) {
        return greaterThanOrEqual(greaterThanOrEqual, Bracket.NONE);
    }

    @Override
    public Conjunction greaterThanOrEqual(Object greaterThanOrEqual, Bracket bracket) {
        initOperator(">=", greaterThanOrEqual, bracket);

        return this;
    }

    @Override
    public Conjunction lessThanOrEqual(Object lessThanOrEqual) {
        return lessThanOrEqual(lessThanOrEqual, condition.getBracket());
    }

    @Override
    public Conjunction lessThanOrEqual(Object lessThanOrEqual, Bracket bracket) {
        initOperator("<=", lessThanOrEqual, bracket);

        return this;
    }

    @Override
    public Conjunction between(Object between) {
        return between(between, condition.getBracket());
    }

    @Override
    public Conjunction between(Object between, Bracket bracket) {
        initOperator("BETWEEN", between, bracket);

        return this;
    }

    @Override
    public Conjunction like(Object like) {
        return like(like, condition.getBracket());
    }

    @Override
    public Conjunction like(Object like, Bracket bracket) {
        initOperator("LIKE", like, bracket);

        return this;
    }

    @Override
    public Conjunction in(Object in) {
        return in(in, condition.getBracket());
    }

    @Override
    public Conjunction in(Object in, Bracket bracket) {
        initOperator("IN", in, bracket);

        return this;
    }

    /* Orders */

    @Override
    public Order orderBy(String orderBy) {
        this.orderBy = orderBy;

        return this;
    }

    @Override
    public Build asc() {
        this.order = "ASC";

        return this;
    }

    @Override
    public Build desc() {
        this.order = "DESC";

        return this;
    }

    /* Build */

    @Override
    public Query build() {
        String query = "SELECT " + select + "\n";
        query += "FROM " + from;

        if (!conditionList.isEmpty()) {
            for (Condition condition : conditionList) {
                query += " " + condition.getConjunction() + " ";

                if (condition.getBracket().equals(Bracket.OPEN)) {
                    query += condition.getBracket().getValue();
                }

                query += condition.getWhere() + " " + condition.getOperator() + " " + condition.getWhat();

                if (condition.getBracket().equals(Bracket.CLOSE)) {
                    query += condition.getBracket().getValue();
                }
            }
        }

        if (orderBy != null) {
            query += "\nORDER BY " + orderBy + " " + order;
        }

        query += ";";

        return new Query(query);
    }

    private void initConjunction(String conjunction, String where, Bracket bracket) {
        condition.setConjunction(conjunction);
        condition.setWhere(where);
        condition.setBracket(bracket);
    }

    private void initOperator(String operator, Object what, Bracket bracket) {
        condition.setOperator(operator);
        condition.setWhat(what);
        condition.setBracket(bracket);

        addCondition();
    }

    private void addCondition() {
        conditionList.add(condition);
        condition = new Condition();
    }

}
