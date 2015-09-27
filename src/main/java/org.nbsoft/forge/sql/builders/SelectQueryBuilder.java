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
import org.nbsoft.forge.sql.syntax.*;

import java.util.ArrayList;
import java.util.List;

public class SelectQueryBuilder implements SelectQuery {

    private String select;
    private String from;

    private List<String> conjunctionList = new ArrayList<>();
    private List<String> whereList = new ArrayList<>();
    private List<String> operatorList = new ArrayList<>();
    private List<Object> whatList = new ArrayList<>();

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
        conjunctionList.add("WHERE");
        whereList.add(where);

        return this;
    }

    @Override
    public Operator and(String and) {
        conjunctionList.add("AND");
        whereList.add(and);

        return this;
    }

    @Override
    public Operator or(String or) {
        conjunctionList.add("OR");
        whereList.add(or);

        return this;
    }

    /* Operators */

    @Override
    public Conjunction equal(Object equal) {
        operatorList.add("=");
        whatList.add(equal);

        return this;
    }

    @Override
    public Conjunction notEqual(Object notEqual) {
        operatorList.add("<>");
        whatList.add(notEqual);

        return this;
    }

    @Override
    public Conjunction greaterThan(Object greaterThan) {
        operatorList.add(">");
        whatList.add(greaterThan);

        return this;
    }

    @Override
    public Conjunction lessThan(Object lessThan) {
        operatorList.add("<");
        whatList.add(lessThan);

        return this;
    }

    @Override
    public Conjunction greaterThanOrEqual(Object greaterThanOrEqual) {
        operatorList.add(">=");
        whatList.add(greaterThanOrEqual);

        return this;
    }

    @Override
    public Conjunction lessThanOrEqual(Object greaterThanOrEqual) {
        operatorList.add("<=");
        whatList.add(greaterThanOrEqual);

        return this;
    }

    @Override
    public Conjunction between(Object between) {
        operatorList.add("BETWEEN");
        whatList.add(between);

        return this;
    }

    @Override
    public Conjunction like(Object like) {
        operatorList.add("LIKE");
        whatList.add(like);

        return this;
    }

    @Override
    public Conjunction in(Object in) {
        operatorList.add("IN");
        whatList.add(in);

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

        if (!conjunctionList.isEmpty()) {
            for (int i = 0; i < conjunctionList.size(); i++) {
                if (!conjunctionList.get(i).equals("AND")) {
                    query += "\n";
                } else {
                    query += " ";
                }

                query += conjunctionList.get(i) + " " + whereList.get(i) + " " + operatorList.get(i) + " " + whatList.get(i);
            }
        }

        if (orderBy != null) {
            query += "\nORDER BY " + orderBy + " " + order;
        }

        query += ";";

        return new Query(query);
    }

}
